package com.baidu.tieba.video.player.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.j.a {
    private View drq;
    private View huI;
    private a huJ;

    /* loaded from: classes3.dex */
    public interface a {
        void bCN();

        void bCO();
    }

    public c(Context context) {
        super(LayoutInflater.from(context).inflate(d.h.video_replay_layout, (ViewGroup) null));
        this.drq = this.bxA.findViewById(d.g.video_replay_container);
        this.huI = this.bxA.findViewById(d.g.video_reply_lay);
        this.huI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.huJ != null) {
                    c.this.huJ.bCN();
                }
            }
        });
        this.drq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.huJ != null) {
                    c.this.huJ.bCO();
                }
            }
        });
    }

    public void a(a aVar) {
        this.huJ = aVar;
    }
}
