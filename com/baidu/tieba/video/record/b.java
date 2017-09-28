package com.baidu.tieba.video.record;

import android.media.AudioRecord;
/* loaded from: classes2.dex */
public class b {
    public static boolean bwU() {
        return bwV() != -2;
    }

    private static int bwV() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                if (audioRecord != null) {
                    a(audioRecord);
                    audioRecord.release();
                }
                return -1;
            } else if (audioRecord.read(sArr, 0, sArr.length) <= 0) {
                if (audioRecord != null) {
                    a(audioRecord);
                    audioRecord.release();
                }
                return -2;
            } else {
                if (audioRecord != null) {
                    a(audioRecord);
                    audioRecord.release();
                }
                return 1;
            }
        } catch (Exception e) {
            if (audioRecord != null) {
                audioRecord.release();
            }
            return -2;
        }
    }

    private static void a(AudioRecord audioRecord) {
        if (audioRecord != null) {
            try {
                audioRecord.stop();
            } catch (Throwable th) {
            }
        }
    }
}
