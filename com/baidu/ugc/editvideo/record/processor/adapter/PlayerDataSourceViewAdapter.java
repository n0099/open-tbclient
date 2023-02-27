package com.baidu.ugc.editvideo.record.processor.adapter;

import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView;
import com.baidu.ugc.editvideo.record.source.IDataSourceView;
/* loaded from: classes7.dex */
public class PlayerDataSourceViewAdapter implements IDataSourceView.IPlayerDataSourceView {
    public IPlayer.OnPlayerCompletionListener mOnCompleteListener;
    public IPlayer.OnPlayerErrorListener mOnErrorListener;
    public IPlayer.OnPlayerInfoListener mOnInfoListener;
    public IPlayer.OnPlayerPlayStateListener mOnPlayStateListener;
    public IPlayer.OnPlayerPreparedListener mOnPreparedListener;
    public GLMediaPreviewView mVideoView;

    public PlayerDataSourceViewAdapter(GLMediaPreviewView gLMediaPreviewView) {
        this.mVideoView = gLMediaPreviewView;
    }

    private void removeListeners() {
        this.mOnPreparedListener = null;
        this.mOnCompleteListener = null;
        this.mOnPlayStateListener = null;
        this.mOnInfoListener = null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onCompletion(IPlayer iPlayer) {
        IPlayer.OnPlayerCompletionListener onPlayerCompletionListener = this.mOnCompleteListener;
        if (onPlayerCompletionListener != null) {
            onPlayerCompletionListener.onCompletion(iPlayer);
        }
    }

    public void onDestroy() {
        removeListeners();
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onError(IPlayer iPlayer, int i, int i2, Exception exc) {
        IPlayer.OnPlayerErrorListener onPlayerErrorListener = this.mOnErrorListener;
        if (onPlayerErrorListener != null) {
            onPlayerErrorListener.onError(iPlayer, i, i2, exc);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onInfo(IPlayer iPlayer, int i, int i2) {
        IPlayer.OnPlayerInfoListener onPlayerInfoListener = this.mOnInfoListener;
        if (onPlayerInfoListener != null) {
            onPlayerInfoListener.onInfo(iPlayer, i, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPlayStateListener(IPlayer iPlayer, int i) {
        IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener = this.mOnPlayStateListener;
        if (onPlayerPlayStateListener != null) {
            onPlayerPlayStateListener.onStateChange(iPlayer, i);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPrepared(IPlayer iPlayer) {
        IPlayer.OnPlayerPreparedListener onPlayerPreparedListener = this.mOnPreparedListener;
        if (onPlayerPreparedListener != null) {
            onPlayerPreparedListener.onPrepared(iPlayer);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onVideoSizeChanged(int i, int i2) {
        GLMediaPreviewView gLMediaPreviewView = this.mVideoView;
        if (gLMediaPreviewView != null) {
            gLMediaPreviewView.onVideoSizeChanged(i, i2);
        }
    }

    public void setOnCompleteListener(IPlayer.OnPlayerCompletionListener onPlayerCompletionListener) {
        this.mOnCompleteListener = onPlayerCompletionListener;
    }

    public void setOnErrorListener(IPlayer.OnPlayerErrorListener onPlayerErrorListener) {
        this.mOnErrorListener = onPlayerErrorListener;
    }

    public void setOnInfoListener(IPlayer.OnPlayerInfoListener onPlayerInfoListener) {
        this.mOnInfoListener = onPlayerInfoListener;
    }

    public void setOnPlayStateListener(IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener) {
        this.mOnPlayStateListener = onPlayerPlayStateListener;
    }

    public void setOnPreparedListener(IPlayer.OnPlayerPreparedListener onPlayerPreparedListener) {
        this.mOnPreparedListener = onPlayerPreparedListener;
    }
}
