package com.baidu.yuyinala.privatemessage.implugin.util.audio;
/* loaded from: classes11.dex */
public class AudioRecords {
    private static final String TAG = AudioRecords.class.getSimpleName();
    public static final FormatFactory pbD = FormatFactory.AMR_NB;

    /* loaded from: classes11.dex */
    public enum FormatFactory {
        DEFAULT(0, "DEFAULT"),
        THREE_GPP(1, "3gpp"),
        MPEG_4(2, "mp4"),
        RAW_AMR(3, "raw"),
        AMR_NB(3, "amr"),
        AMR_WB(4, "amr"),
        AAC_ADTS(6, "aac"),
        WEBM(9, "webm"),
        MP3(2, "mp3");
        
        private int mFormatCode;
        private String mFormatDesc;

        FormatFactory(int i, String str) {
            this.mFormatCode = i;
            this.mFormatDesc = str;
        }

        public int getFormatCode() {
            return this.mFormatCode;
        }

        public String getFormatDesc() {
            return this.mFormatDesc;
        }
    }
}
