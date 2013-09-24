package com.baidu.tieba.voice.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.location.LocationClientOption;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MediaService extends Service implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private int mElapsedTime = 0;
    private long mStartRecorderTime = 0;
    private Handler mHandler = new Handler();
    private int mCurBeginSecond = 0;
    private Voice mVoice = null;
    private String mFilePath = new String();
    private Runnable mPlayTimeThread = new c(this);
    private Runnable mRecordTimeThread = new d(this);
    private h mRecorder = null;
    private g mPlayer = j.h();
    long mSeekTime = 0;

    public static void preparePlay(Context context, String str, int i) {
        preparePlay(context, str, i, 0);
    }

    public static void preparePlay(Context context, String str, int i, int i2) {
        Intent intent = new Intent();
        intent.setAction("preparePlayer");
        Voice voice = new Voice();
        voice.a(str);
        voice.a(i);
        intent.putExtra("com.baidu.voices", voice);
        intent.putExtra("com.baidu.msg.curr_time", i2);
        startMy(context, intent);
    }

    public static void startPlay(Context context) {
        Intent intent = new Intent();
        intent.setAction("playVoice");
        startMy(context, intent);
    }

    public static void pausePlay(Context context) {
        Intent intent = new Intent();
        intent.setAction("pauseVoice");
        startMy(context, intent);
    }

    public static void seekVoice(Context context, long j) {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.seekTime", j);
        intent.setAction("seekVoice");
        startMy(context, intent);
    }

    public static void stopAndReplayVoice(Context context) {
        Intent intent = new Intent();
        intent.setAction("stopAndReplay");
        startMy(context, intent);
    }

    public static void stopPlay(Context context) {
        Intent intent = new Intent();
        intent.setAction("stopVoice");
        startMy(context, intent);
    }

    public static void startMy(Context context, Intent intent) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, MediaService.class);
            context.startService(intent);
        }
    }

    public static void stopMy(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, MediaService.class);
            try {
                context.stopService(intent);
            } catch (Exception e) {
            }
        }
    }

    public static void initBroadcastReceivers(Context context, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.playPrepared");
        intentFilter.addAction("com.baidu.isPlaying");
        intentFilter.addAction("com.baidu.isStoped");
        intentFilter.addAction("com.baidu.playElapsedTime");
        intentFilter.addAction("com.baidu.recognize");
        android.support.v4.content.f.a(context).a(broadcastReceiver, intentFilter);
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context != null && broadcastReceiver != null) {
            try {
                android.support.v4.content.f.a(context).a(broadcastReceiver);
            } catch (Exception e) {
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    private void setPlayerCompleteListener() {
        if (this.mPlayer != null && (this.mPlayer instanceof j)) {
            ((j) this.mPlayer).setOnErrorListener(this);
            ((j) this.mPlayer).setOnPreparedListener(this);
            ((j) this.mPlayer).setOnCompletionListener(new e(this));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mPlayTimeThread);
        }
        this.mHandler = null;
        this.mVoice = null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        String action = intent.getAction();
        if (action == null || action.length() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        try {
            Method declaredMethod = getClass().getDeclaredMethod(action, Intent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void preparePlayer(Intent intent) {
        this.mVoice = (Voice) intent.getParcelableExtra("com.baidu.voices");
        int intExtra = intent.getIntExtra("com.baidu.msg.curr_time", 0);
        if (intExtra < 0) {
            intExtra = 0;
        }
        if (this.mVoice != null) {
            setPlayerCompleteListener();
            tryPreparePlayVoices(intExtra);
        }
    }

    private void tryPreparePlayVoices(long j) {
        this.mSeekTime = j;
        Voice voice = this.mVoice;
        j.h().d();
        if (!this.mPlayer.a(voice.a()) && this.mPlayer.g() != -1) {
            Intent intent = new Intent("com.baidu.playPrepared");
            intent.putExtra("com.baidu.playPrepared_err_code", this.mPlayer.g());
            sendBroadcast(intent);
            this.mSeekTime = 0L;
        }
        this.mCurBeginSecond = 0;
    }

    private void playVoice(Intent intent) {
        if (this.mPlayer != null && this.mPlayer.f()) {
            this.mPlayer.a();
            this.mHandler.post(this.mPlayTimeThread);
            if (this.mPlayer.isPlaying()) {
                Intent intent2 = new Intent("com.baidu.isPlaying");
                intent2.putExtra("com.baidu.msg.isPlaying", true);
                sendBroadcast(intent2);
            }
        }
    }

    private void pauseVoice(Intent intent) {
        if (this.mPlayer.isPlaying()) {
            this.mPlayer.c();
            this.mHandler.removeCallbacks(this.mPlayTimeThread);
            if (!this.mPlayer.isPlaying()) {
                Intent intent2 = new Intent("com.baidu.isPlaying");
                intent2.putExtra("com.baidu.msg.isPlaying", false);
                sendBroadcast(intent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice(Intent intent) {
        this.mHandler.removeCallbacks(this.mPlayTimeThread);
        this.mElapsedTime = 0;
        this.mCurBeginSecond = 0;
        if (this.mPlayer instanceof j) {
            ((j) this.mPlayer).setOnCompletionListener(null);
        }
        int e = this.mPlayer.e();
        Intent intent2 = new Intent("com.baidu.isStoped");
        intent2.putExtra("com.baidu.msg.curr_time", e);
        sendBroadcast(intent2);
        this.mPlayer.b();
    }

    private void stopAndReplay(Intent intent) {
        if (this.mVoice != null && this.mPlayer != null) {
            long e = this.mPlayer.e();
            if (e >= 0) {
                this.mPlayer.b();
                this.mPlayer.d();
                long b = this.mVoice.b();
                if (b > 0 && e <= b) {
                    if (this.mPlayer instanceof j) {
                        ((j) this.mPlayer).setOnPreparedListener(null);
                    }
                    if (this.mPlayer.a(this.mVoice.a())) {
                        this.mPlayer.a((int) e);
                        playVoice(null);
                    }
                }
            }
        }
    }

    private void seekVoice(Intent intent) {
        if (this.mVoice != null) {
            this.mPlayer.d();
            long longExtra = intent.getLongExtra("com.baidu.seekTime", 0L);
            if (longExtra >= 0) {
                long b = this.mVoice.b();
                if (b > 0 && longExtra <= b) {
                    if (this.mPlayer instanceof j) {
                        ((j) this.mPlayer).setOnPreparedListener(null);
                    }
                    if (this.mPlayer.a(this.mVoice.a())) {
                        this.mPlayer.a((int) longExtra);
                        playVoice(null);
                    }
                }
            }
        }
    }

    private void startRecord(Intent intent) {
        if (this.mRecorder != null) {
            this.mRecorder.a();
            this.mStartRecorderTime = System.currentTimeMillis();
            this.mHandler.post(this.mRecordTimeThread);
            Intent intent2 = new Intent("com.baidu.mediaIsRecording");
            intent2.putExtra("com.baidu.msg.isRecording", true);
            sendBroadcast(intent2);
        }
    }

    private void prepareRecorder(Intent intent) {
        String stringExtra = intent.getStringExtra("com.baidu.notePath");
        String stringExtra2 = intent.getStringExtra("filePath");
        if (stringExtra2.endsWith(".amr")) {
            this.mRecorder = MyAudioRecorder.a((Boolean) true);
        } else {
            this.mRecorder = new a();
        }
        boolean z = false;
        File file = new File(stringExtra);
        this.mFilePath = String.valueOf(stringExtra) + File.separator + stringExtra2;
        if (file.exists()) {
            if (file.isDirectory() && file.canRead() && file.canWrite()) {
                z = this.mRecorder.a(this.mFilePath);
            }
        } else {
            file.mkdir();
            if (file.isDirectory() && file.canRead() && file.canWrite()) {
                z = this.mRecorder.a(this.mFilePath);
            }
        }
        if (z) {
            Intent intent2 = new Intent();
            intent2.setAction("com.baidu.recordPrepared");
            intent2.putExtra("com.baidu.msg.recordPrepared", true);
            intent2.putExtra("com.baidu.msg.preparedName", stringExtra2);
            sendBroadcast(intent2);
        }
    }

    private void stopRecord(Intent intent) {
        if (this.mRecorder != null) {
            this.mRecorder.b();
            this.mHandler.removeCallbacks(this.mRecordTimeThread);
            Intent intent2 = new Intent("com.baidu.recordStopped");
            intent2.putExtra("com.baidu.msg.recordElapsedTime", this.mElapsedTime);
            File file = new File(this.mFilePath);
            if (file.exists()) {
                intent2.putExtra("com.baidu.msg.sizeofbyte", file.length());
            }
            sendBroadcast(intent2);
            this.mStartRecorderTime = 0L;
            this.mElapsedTime = 0;
        }
    }

    private void pauseRecord(Intent intent) {
        if (this.mRecorder != null && this.mRecorder.c()) {
            this.mRecorder.b();
            this.mHandler.removeCallbacks(this.mRecordTimeThread);
            Intent intent2 = new Intent("com.baidu.recordPaused");
            intent2.putExtra("com.baidu.msg.recordElapsedTime", this.mElapsedTime);
            sendBroadcast(intent2);
            this.mStartRecorderTime = 0L;
            this.mElapsedTime = 0;
        }
    }

    private int getVoiceTotalTime() {
        if (this.mVoice == null) {
            return 0;
        }
        long b = this.mVoice.b();
        if (b == 0 && (this.mPlayer instanceof j)) {
            b = ((j) this.mPlayer).getDuration() / LocationClientOption.MIN_SCAN_SPAN;
        }
        return (int) b;
    }

    private long getVoiceTotalTimeByMediaPlayer() {
        if (!(this.mPlayer instanceof j)) {
            return 0L;
        }
        return ((j) this.mPlayer).getDuration();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        android.support.v4.content.f.a(this).a(intent);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Intent intent = new Intent("com.baidu.playPrepared");
        intent.setFlags(1073741824);
        intent.putExtra("com.baidu.playPrepared_err_code", -1);
        int voiceTotalTime = getVoiceTotalTime();
        long j = voiceTotalTime * LocationClientOption.MIN_SCAN_SPAN;
        long voiceTotalTimeByMediaPlayer = getVoiceTotalTimeByMediaPlayer();
        if (voiceTotalTimeByMediaPlayer - j > 1000 || voiceTotalTimeByMediaPlayer < j) {
            voiceTotalTimeByMediaPlayer = j;
        }
        intent.putExtra("com.baidu.msg.durationTime", voiceTotalTime);
        intent.putExtra("com.baidu.msg.durationTime2", voiceTotalTimeByMediaPlayer);
        if (this.mSeekTime > 0) {
            int i = (int) this.mSeekTime;
        }
        this.mSeekTime = 0L;
        sendBroadcast(intent);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }
}
