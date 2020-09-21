package com.baidu.tieba.video.record;

import android.media.AudioRecord;
/* loaded from: classes22.dex */
public class c {
    public static boolean dGO() {
        return dGP() != -2;
    }

    private static int dGP() {
        AudioRecord audioRecord;
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
            try {
                audioRecord.startRecording();
                if (audioRecord.getRecordingState() != 3) {
                    if (audioRecord != null) {
                        a(audioRecord);
                        audioRecord.release();
                    }
                    return -2;
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
        } catch (Exception e2) {
            audioRecord = null;
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
