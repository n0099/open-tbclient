package com.baidu.zeus;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes.dex */
public class ProxyProperties implements Parcelable {
    public static final Parcelable.Creator<ProxyProperties> CREATOR = new Parcelable.Creator<ProxyProperties>() { // from class: com.baidu.zeus.ProxyProperties.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProxyProperties createFromParcel(Parcel parcel) {
            String str;
            int i = 0;
            if (parcel.readByte() == 1) {
                str = parcel.readString();
                i = parcel.readInt();
            } else {
                str = null;
            }
            return new ProxyProperties(str, i, parcel.readString(), parcel.readStringArray());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProxyProperties[] newArray(int i) {
            return new ProxyProperties[i];
        }
    };
    private String mExclusionList;
    private String mHost;
    private String[] mParsedExclusionList;
    private int mPort;

    public ProxyProperties(String str, int i, String str2) {
        this.mHost = str;
        this.mPort = i;
        setExclusionList(str2);
    }

    private ProxyProperties(String str, int i, String str2, String[] strArr) {
        this.mHost = str;
        this.mPort = i;
        this.mExclusionList = str2;
        this.mParsedExclusionList = strArr;
    }

    public ProxyProperties(ProxyProperties proxyProperties) {
        if (proxyProperties != null) {
            this.mHost = proxyProperties.getHost();
            this.mPort = proxyProperties.getPort();
            this.mExclusionList = proxyProperties.getExclusionList();
            this.mParsedExclusionList = proxyProperties.mParsedExclusionList;
        }
    }

    public InetSocketAddress getSocketAddress() {
        try {
            return new InetSocketAddress(this.mHost, this.mPort);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public String getHost() {
        return this.mHost;
    }

    public int getPort() {
        return this.mPort;
    }

    public String getExclusionList() {
        return this.mExclusionList;
    }

    private void setExclusionList(String str) {
        this.mExclusionList = str;
        if (this.mExclusionList == null) {
            this.mParsedExclusionList = new String[0];
            return;
        }
        String[] split = str.toLowerCase().split(",");
        this.mParsedExclusionList = new String[split.length * 2];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.startsWith(".")) {
                trim = trim.substring(1);
            }
            this.mParsedExclusionList[i * 2] = trim;
            this.mParsedExclusionList[(i * 2) + 1] = "." + trim;
        }
    }

    public boolean isExcluded(String str) {
        if (TextUtils.isEmpty(str) || this.mParsedExclusionList == null || this.mParsedExclusionList.length == 0) {
            return false;
        }
        Log.v("ProxyProperties", "----in isExcluded");
        return true;
    }

    public Proxy makeProxy() {
        Proxy proxy = Proxy.NO_PROXY;
        if (this.mHost != null) {
            try {
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.mHost, this.mPort));
            } catch (IllegalArgumentException e) {
                return proxy;
            }
        }
        return proxy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mHost != null) {
            sb.append("[");
            sb.append(this.mHost);
            sb.append("] ");
            sb.append(Integer.toString(this.mPort));
            if (this.mExclusionList != null) {
                sb.append(" xl=").append(this.mExclusionList);
            }
        } else {
            sb.append("[ProxyProperties.mHost == null]");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ProxyProperties) {
            ProxyProperties proxyProperties = (ProxyProperties) obj;
            if (this.mExclusionList == null || this.mExclusionList.equals(proxyProperties.getExclusionList())) {
                if (this.mHost == null || proxyProperties.getHost() == null || this.mHost.equals(proxyProperties.getHost())) {
                    if (this.mHost == null || proxyProperties.mHost != null) {
                        return (this.mHost != null || proxyProperties.mHost == null) && this.mPort == proxyProperties.mPort;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return (this.mHost == null ? 0 : this.mHost.hashCode()) + (this.mExclusionList != null ? this.mExclusionList.hashCode() : 0) + this.mPort;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.mHost != null) {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.mHost);
            parcel.writeInt(this.mPort);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.mExclusionList);
        parcel.writeStringArray(this.mParsedExclusionList);
    }
}
