package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
@Deprecated
/* loaded from: classes.dex */
public class Plugin {
    private String mDescription;
    private String mFileName;
    private PreferencesClickHandler mHandler = new DefaultClickHandler();
    private String mName;
    private String mPath;

    /* loaded from: classes.dex */
    public interface PreferencesClickHandler {
        void handleClickEvent(Context context);
    }

    @Deprecated
    public Plugin(String str, String str2, String str3, String str4) {
        this.mName = str;
        this.mPath = str2;
        this.mFileName = str3;
        this.mDescription = str4;
    }

    @Deprecated
    public String toString() {
        return this.mName;
    }

    @Deprecated
    public String getName() {
        return this.mName;
    }

    @Deprecated
    public String getPath() {
        return this.mPath;
    }

    @Deprecated
    public String getFileName() {
        return this.mFileName;
    }

    @Deprecated
    public String getDescription() {
        return this.mDescription;
    }

    @Deprecated
    public void setName(String str) {
        this.mName = str;
    }

    @Deprecated
    public void setPath(String str) {
        this.mPath = str;
    }

    @Deprecated
    public void setFileName(String str) {
        this.mFileName = str;
    }

    @Deprecated
    public void setDescription(String str) {
        this.mDescription = str;
    }

    @Deprecated
    public void setClickHandler(PreferencesClickHandler preferencesClickHandler) {
        this.mHandler = preferencesClickHandler;
    }

    @Deprecated
    public void dispatchClickEvent(Context context) {
        if (this.mHandler != null) {
            this.mHandler.handleClickEvent(context);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    class DefaultClickHandler implements DialogInterface.OnClickListener, PreferencesClickHandler {
        private AlertDialog mDialog;

        private DefaultClickHandler() {
        }

        @Override // com.baidu.zeus.Plugin.PreferencesClickHandler
        @Deprecated
        public void handleClickEvent(Context context) {
            if (this.mDialog == null) {
                this.mDialog = new AlertDialog.Builder(context).setTitle(Plugin.this.mName).setMessage(Plugin.this.mDescription).setPositiveButton("OK", this).setCancelable(false).show();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Deprecated
        public void onClick(DialogInterface dialogInterface, int i) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }
}
