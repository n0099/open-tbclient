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
    private final String[] bxD;
    private TextView bxE;
    private final int bxF;
    private Runnable bxG;
    private int currentIndex;
    private ImageView huy;
    private TbImageView huz;
    private Context mContext;

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(d.h.video_loading_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.bxG = new Runnable() { // from class: com.baidu.tieba.video.player.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.bxE.setText(a.this.bxD[a.this.MM()]);
                TbadkCoreApplication.getInst().handler.postDelayed(a.this.bxG, 200L);
            }
        };
        this.mContext = context;
        this.bxE = (TextView) this.bxA.findViewById(d.g.video_player_loading_text);
        this.huy = (ImageView) this.bxA.findViewById(d.g.video_player_loading_image);
        this.bxD = context.getResources().getStringArray(d.b.video_loading_text);
        this.bxF = this.bxD.length;
        this.huz = (TbImageView) this.bxA.findViewById(d.g.video_player_thumbnail_pic);
        this.huz.setDefaultResource(0);
        this.huz.setDefaultErrorResource(0);
        this.huz.setDefaultBgResource(0);
    }

    public void p(String str, int i, int i2) {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.huz.getLayoutParams();
        if (i > 0) {
            layoutParams.height = (int) (width * ((i2 * 1.0f) / i));
            this.huz.setLayoutParams(layoutParams);
            this.huz.startLoad(str, 13, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MM() {
        this.currentIndex++;
        if (this.currentIndex >= this.bxF) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        this.huy.setImageResource(d.f.btn_icon_video_n);
        this.bxE.setText(this.bxD[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxG);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bxG, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void ML() {
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxG);
        this.huy.setImageResource(0);
    }
}
