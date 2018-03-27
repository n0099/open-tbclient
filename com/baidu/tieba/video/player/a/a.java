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
    private final String[] bxt;
    private TextView bxu;
    private final int bxv;
    private Runnable bxw;
    private int currentIndex;
    private ImageView huJ;
    private TbImageView huK;
    private Context mContext;

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(d.h.video_loading_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.bxw = new Runnable() { // from class: com.baidu.tieba.video.player.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bxu.setText(a.this.bxt[a.this.MM()]);
                TbadkCoreApplication.getInst().handler.postDelayed(a.this.bxw, 200L);
            }
        };
        this.mContext = context;
        this.bxu = (TextView) this.bxq.findViewById(d.g.video_player_loading_text);
        this.huJ = (ImageView) this.bxq.findViewById(d.g.video_player_loading_image);
        this.bxt = context.getResources().getStringArray(d.b.video_loading_text);
        this.bxv = this.bxt.length;
        this.huK = (TbImageView) this.bxq.findViewById(d.g.video_player_thumbnail_pic);
        this.huK.setDefaultResource(0);
        this.huK.setDefaultErrorResource(0);
        this.huK.setDefaultBgResource(0);
    }

    public void p(String str, int i, int i2) {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.huK.getLayoutParams();
        if (i > 0) {
            layoutParams.height = (int) (width * ((i2 * 1.0f) / i));
            this.huK.setLayoutParams(layoutParams);
            this.huK.startLoad(str, 13, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MM() {
        this.currentIndex++;
        if (this.currentIndex >= this.bxv) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        this.huJ.setImageResource(d.f.btn_icon_video_n);
        this.bxu.setText(this.bxt[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxw);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bxw, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void ML() {
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxw);
        this.huJ.setImageResource(0);
    }
}
