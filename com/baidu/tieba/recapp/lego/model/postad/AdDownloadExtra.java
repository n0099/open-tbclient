package com.baidu.tieba.recapp.lego.model.postad;
/* loaded from: classes13.dex */
public class AdDownloadExtra {

    /* loaded from: classes13.dex */
    public enum STATUS {
        STATUS_NONE(0),
        STATUS_DOWNLOADING(1),
        STATUS_PAUSED(2),
        STATUS_SUCCESS(3),
        STATUS_INSTALL_SUCCESS(4);
        
        public final int status;

        STATUS(int i) {
            this.status = i;
        }

        public static STATUS parse(int i) {
            STATUS[] values;
            for (STATUS status : values()) {
                if (status.ordinal() == i) {
                    return status;
                }
            }
            return STATUS_NONE;
        }
    }
}
