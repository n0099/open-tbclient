package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes13.dex */
public interface IVrPlayView {
    void buffer();

    void complete();

    void error();

    GLTextureView getGLView();

    TbPageContext<?> getPageContext();

    void loading();

    void onDestroy();

    void pause();

    void play();

    void setClickListener(View.OnClickListener onClickListener);

    void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener);

    void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl);

    void setSeekBarTime(int i, int i2);

    void showPanoramaPrompt();
}
