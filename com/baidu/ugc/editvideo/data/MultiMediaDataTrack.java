package com.baidu.ugc.editvideo.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.tieba.r7a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MultiMediaDataTrack implements Parcelable, Cloneable {
    public static final Parcelable.Creator<MultiMediaDataTrack> CREATOR = new Parcelable.Creator<MultiMediaDataTrack>() { // from class: com.baidu.ugc.editvideo.data.MultiMediaDataTrack.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiMediaDataTrack createFromParcel(Parcel parcel) {
            return new MultiMediaDataTrack(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiMediaDataTrack[] newArray(int i) {
            return new MultiMediaDataTrack[i];
        }
    };
    public List<MultiMediaData> multiMediaDataList;
    public MultiMediaData multiMediaDataSuperpositionFooter;
    public MultiMediaData multiMediaDataSuperpositionHeader;

    public MultiMediaDataTrack() {
    }

    public MultiMediaDataTrack(Parcel parcel) {
        this.multiMediaDataList = parcel.createTypedArrayList(MultiMediaData.CREATOR);
        this.multiMediaDataSuperpositionHeader = (MultiMediaData) parcel.readParcelable(MultiMediaData.class.getClassLoader());
        this.multiMediaDataSuperpositionFooter = (MultiMediaData) parcel.readParcelable(MultiMediaData.class.getClassLoader());
    }

    public Object clone() {
        try {
            MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) super.clone();
            if (this.multiMediaDataSuperpositionHeader != null) {
                multiMediaDataTrack.multiMediaDataSuperpositionHeader = (MultiMediaData) this.multiMediaDataSuperpositionHeader.clone();
            }
            if (this.multiMediaDataSuperpositionFooter != null) {
                multiMediaDataTrack.multiMediaDataSuperpositionFooter = (MultiMediaData) this.multiMediaDataSuperpositionFooter.clone();
            }
            ArrayList arrayList = new ArrayList();
            for (MultiMediaData multiMediaData : this.multiMediaDataList) {
                arrayList.add((MultiMediaData) multiMediaData.clone());
            }
            multiMediaDataTrack.multiMediaDataList = arrayList;
            return multiMediaDataTrack;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new MultiMediaDataTrack();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean hasFooter() {
        if (r7a.e(this.multiMediaDataList) || this.multiMediaDataList.size() < 1) {
            return false;
        }
        List<MultiMediaData> list = this.multiMediaDataList;
        return MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(list.get(list.size() - 1).inputType);
    }

    public boolean hasHeader() {
        if (r7a.e(this.multiMediaDataList) || this.multiMediaDataList.get(0) == null) {
            return false;
        }
        return MediaSegment.SEG_TYPE_INPUT_HEADER.equals(this.multiMediaDataList.get(0).inputType);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.multiMediaDataList);
        parcel.writeParcelable(this.multiMediaDataSuperpositionHeader, i);
        parcel.writeParcelable(this.multiMediaDataSuperpositionFooter, i);
    }
}
