package com.baidu.tieba.video.player.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.j.a {
    private View dre;
    private View huv;
    private a huw;

    /* loaded from: classes3.dex */
    public interface a {
        void bCM();

        void bCN();
    }

    public c(Context context) {
        super(LayoutInflater.from(context).inflate(d.h.video_replay_layout, (ViewGroup) null));
        this.dre = this.bxn.findViewById(d.g.video_replay_container);
        this.huv = this.bxn.findViewById(d.g.video_reply_lay);
        this.huv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.huw != null) {
                    c.this.huw.bCM();
                }
            }
        });
        this.dre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.huw != null) {
                    c.this.huw.bCN();
                }
            }
        });
    }

    public void a(a aVar) {
        this.huw = aVar;
    }
}
