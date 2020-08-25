package com.baidu.webkit.sdk;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.HashMap;
/* loaded from: classes19.dex */
public abstract class VideoPlayer {
    public static final int DATA_ID_ATTRIBUTE_ID = 8;
    public static final int DATA_ID_AUTOPLAY = 15;
    public static final int DATA_ID_COOKIE = 3;
    public static final int DATA_ID_FIXED = 14;
    public static final int DATA_ID_HEIGHT = 13;
    public static final int DATA_ID_HIDE_URL_LOG = 4;
    public static final int DATA_ID_HTTP_HEADER = 7;
    public static final int DATA_ID_PLAYER_EXT = 16;
    public static final int DATA_ID_PROXY = 6;
    public static final int DATA_ID_REFERRER = 9;
    public static final int DATA_ID_USER_AGENT = 2;
    public static final int DATA_ID_VIDEO_TITLE = 1;
    public static final int DATA_ID_VIDEO_URL = 0;
    public static final int DATA_ID_WEB_URL = 5;
    public static final int DATA_ID_WIDTH = 12;
    public static final int DATA_ID_X = 10;
    public static final int DATA_ID_Y = 11;
    public static final int ERROR_TYPE_DECODE = 1;
    public static final int ERROR_TYPE_DISPLAY = 2;
    public static final int ERROR_TYPE_FORMAT = 0;
    public static final int ERROR_TYPE_IO = 3;
    public static final int ERROR_TYPE_OTHER = 1000;
    public static final int INFO_BUFFERING = 0;
    public static final int INFO_CANCEL_PLAY = 100;
    public static final int INFO_ENTER_FULLSCREEN = 105;
    public static final int INFO_EXIT_FULLSCREEN = 101;
    public static final int INFO_NEED_FILTER_CLICK = 102;
    public static final int INFO_NET_SPEED = 1;
    public static final int INFO_ON_SEEK_COMPLETED = 104;
    public static final int INFO_VIDEO_SIZE_CHANGED = 103;
    public static final int NOTIFY_ENTER_FULLSCREEN = 1;
    public static final int NOTIFY_EXIT_FULLSCREEN = 2;
    public static final int NOTIFY_SET_HTTP_PROXY_HEADER = 4;
    public static final int NOTIFY_SET_RATE = 6;
    public static final int NOTIFY_SET_SURFACE = 3;
    public static final int NOTIFY_SET_VOLUME = 5;
    public static final int NOTIFY_SET_ZEUS_VIDEO_EXT = 8;
    public static final int NOTIFY_UPDATE_VIDEO_RECT = 7;
    protected Context mContext;
    protected VideoPlayerListener mListener;

    /* loaded from: classes19.dex */
    public interface VideoPlayerListener {
        void onEnded();

        void onError(int i);

        void onInfo(int i, Object obj);

        void onPaused();

        void onPlayed();

        void onPrepared();
    }

    public VideoPlayer(Context context) {
        this.mContext = context;
    }

    public abstract void end();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public int getPlayedTime() {
        return getCurrentPosition();
    }

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract boolean goBackOrForground(boolean z);

    public abstract boolean isPlaying();

    public boolean needShowDefaultController() {
        return false;
    }

    public abstract void notify(int i, Object obj);

    public abstract void pause();

    public abstract void play();

    public boolean prepareAsync() {
        return false;
    }

    public abstract void resume();

    public abstract void seekTo(int i);

    public abstract void setDataSource(HashMap<Integer, String> hashMap);

    public void setListener(VideoPlayerListener videoPlayerListener) {
        this.mListener = videoPlayerListener;
    }

    public abstract void setVideoViewHolder(FrameLayout frameLayout);
}
