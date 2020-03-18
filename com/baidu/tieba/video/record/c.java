package com.baidu.tieba.video.record;

import android.media.AudioRecord;
import com.baidu.ala.player.StreamConfig;
/* loaded from: classes10.dex */
public class c {
    public static boolean cRr() {
        return cRs() != -2;
    }

    private static int cRs() {
        AudioRecord audioRecord;
        int minBufferSize = AudioRecord.getMinBufferSize(StreamConfig.Audio.AUDIO_FREQUENCY, 16, 2);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord = new AudioRecord(0, StreamConfig.Audio.AUDIO_FREQUENCY, 16, 2, minBufferSize * 100);
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
