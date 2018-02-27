package com.baidu.tieba.video.player.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.j.a {
    private final String[] bxq;
    private TextView bxr;
    private final int bxs;
    private Runnable bxt;
    private int currentIndex;
    private ImageView hul;
    private TbImageView hum;
    private Context mContext;

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(d.h.video_loading_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.bxt = new Runnable() { // from class: com.baidu.tieba.video.player.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bxr.setText(a.this.bxq[a.this.ML()]);
                TbadkCoreApplication.getInst().handler.postDelayed(a.this.bxt, 200L);
            }
        };
        this.mContext = context;
        this.bxr = (TextView) this.bxn.findViewById(d.g.video_player_loading_text);
        this.hul = (ImageView) this.bxn.findViewById(d.g.video_player_loading_image);
        this.bxq = context.getResources().getStringArray(d.b.video_loading_text);
        this.bxs = this.bxq.length;
        this.hum = (TbImageView) this.bxn.findViewById(d.g.video_player_thumbnail_pic);
        this.hum.setDefaultResource(0);
        this.hum.setDefaultErrorResource(0);
        this.hum.setDefaultBgResource(0);
    }

    public void p(String str, int i, int i2) {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.hum.getLayoutParams();
        if (i > 0) {
            layoutParams.height = (int) (width * ((i2 * 1.0f) / i));
            this.hum.setLayoutParams(layoutParams);
            this.hum.startLoad(str, 13, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ML() {
        this.currentIndex++;
        if (this.currentIndex >= this.bxs) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MJ() {
        this.hul.setImageResource(d.f.btn_icon_video_n);
        this.bxr.setText(this.bxq[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxt);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bxt, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxt);
        this.hul.setImageResource(0);
    }
}
