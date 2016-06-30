package com.baidu.tieba.person.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class m extends y.a {
    public int aeK;
    public View ekD;
    public View ekq;
    public LinearLayout eks;
    public View eky;
    public RelativeLayout elA;
    public TextView elB;
    public TextView elC;
    public ImageView elD;
    public RelativeLayout elE;
    public TbImageView elF;
    public TextView elG;
    public TextView elH;
    public TextView elI;
    public RelativeLayout elJ;
    public TbImageView elK;
    public TextView elL;
    public TextView elM;
    public TextView elN;
    public RelativeLayout elO;
    public TextView elP;
    public TextView elQ;
    public TextView elR;
    public RelativeLayout elS;
    public TextView elT;
    public TextView elU;
    public TextView elV;
    public TbImageView elW;
    public TbImageView elX;
    public TbImageView elY;
    public TbImageView elZ;
    public RelativeLayout elw;
    public TextView elx;
    public ImageView ely;
    public TextView elz;
    public TbImageView ema;
    public TbImageView emb;
    private ViewStub emc;
    public a emd;
    private ViewStub eme;
    public a emf;

    /* loaded from: classes.dex */
    public static class a {
        public ViewGroup emg;
        public TbImageView emh;
        public TextView emi;
        public TextView emj;
        public TextView emk;
    }

    public m(View view) {
        super(view);
        this.eky = null;
        this.elw = null;
        this.elx = null;
        this.ely = null;
        this.elz = null;
        this.ekD = null;
        this.ekq = null;
        this.elA = null;
        this.elB = null;
        this.elC = null;
        this.elD = null;
        this.elE = null;
        this.elF = null;
        this.elG = null;
        this.elH = null;
        this.elI = null;
        this.elJ = null;
        this.elK = null;
        this.elL = null;
        this.elM = null;
        this.elN = null;
        this.elO = null;
        this.elP = null;
        this.elQ = null;
        this.elR = null;
        this.elS = null;
        this.elT = null;
        this.elU = null;
        this.elV = null;
        this.elW = null;
        this.elX = null;
        this.elY = null;
        this.elZ = null;
        this.ema = null;
        this.emb = null;
        this.aeK = 3;
        this.eks = (LinearLayout) view.findViewById(u.g.container);
        this.eky = view.findViewById(u.g.top_divider);
        this.ekD = view.findViewById(u.g.head_divider);
        this.ekq = view.findViewById(u.g.mid_divider);
        this.elw = (RelativeLayout) view.findViewById(u.g.thread_head);
        this.elx = (TextView) this.elw.findViewById(u.g.thread_head_title);
        this.ely = (ImageView) this.elw.findViewById(u.g.thread_head_arrow);
        this.elz = (TextView) this.elw.findViewById(u.g.thread_head_msg);
        this.elA = (RelativeLayout) view.findViewById(u.g.thread_none);
        this.elB = (TextView) this.elA.findViewById(u.g.thread_none_title);
        this.elC = (TextView) this.elA.findViewById(u.g.thread_none_msg);
        this.elD = (ImageView) this.elA.findViewById(u.g.thread_none_lock);
        this.elE = (RelativeLayout) view.findViewById(u.g.pic_thread_item);
        this.elF = (TbImageView) this.elE.findViewById(u.g.pic_thread_item_img);
        this.elG = (TextView) this.elE.findViewById(u.g.pic_thread_item_title);
        this.elH = (TextView) this.elE.findViewById(u.g.pic_thread_item_content);
        this.elI = (TextView) this.elE.findViewById(u.g.pic_thread_item_forum_name);
        this.elW = (TbImageView) this.elE.findViewById(u.g.pic_thread_item_play_video_icon);
        this.elY = (TbImageView) this.elE.findViewById(u.g.pic_thread_item_play_video_icon);
        this.elY = (TbImageView) this.elE.findViewById(u.g.pic_thread_item_zhibo_icon);
        this.elJ = (RelativeLayout) view.findViewById(u.g.pic_thread_item1);
        this.elK = (TbImageView) this.elJ.findViewById(u.g.pic_thread_item_img1);
        this.elL = (TextView) this.elJ.findViewById(u.g.pic_thread_item_title1);
        this.elM = (TextView) this.elJ.findViewById(u.g.pic_thread_item_content1);
        this.elN = (TextView) this.elJ.findViewById(u.g.pic_thread_item_forum_name1);
        this.elX = (TbImageView) this.elJ.findViewById(u.g.pic_thread_item_play_video_icon1);
        this.elZ = (TbImageView) this.elJ.findViewById(u.g.pic_thread_item_zhibo_icon1);
        this.elO = (RelativeLayout) view.findViewById(u.g.text_thread_item1);
        this.elP = (TextView) this.elO.findViewById(u.g.text_thread_item_title1);
        this.elQ = (TextView) this.elO.findViewById(u.g.text_thread_item_content1);
        this.elR = (TextView) this.elO.findViewById(u.g.text_thread_item_forum_name1);
        this.ema = (TbImageView) this.elO.findViewById(u.g.text_thread_item_zhibo_icon1);
        this.elS = (RelativeLayout) view.findViewById(u.g.text_thread_item2);
        this.elT = (TextView) this.elS.findViewById(u.g.text_thread_item_title2);
        this.elU = (TextView) this.elS.findViewById(u.g.text_thread_item_content2);
        this.elV = (TextView) this.elS.findViewById(u.g.text_thread_item_forum_name2);
        this.emb = (TbImageView) this.elS.findViewById(u.g.text_thread_item_zhibo_icon2);
        this.emc = (ViewStub) view.findViewById(u.g.thread_ecomm_item_1);
        this.eme = (ViewStub) view.findViewById(u.g.thread_ecomm_item_2);
    }

    public void aLK() {
        if (this.emd == null) {
            View inflate = this.emc.inflate();
            this.emd = new a();
            a(inflate, this.emd);
        }
    }

    public void aLL() {
        if (this.emf == null) {
            View inflate = this.eme.inflate();
            this.emf = new a();
            a(inflate, this.emf);
        }
    }

    private void a(View view, a aVar) {
        aVar.emg = (ViewGroup) view.findViewById(u.g.thread_ecomm_item);
        aVar.emh = (TbImageView) view.findViewById(u.g.thread_ecomm_item_image);
        aVar.emh.setScaleType(ImageView.ScaleType.FIT_XY);
        aVar.emi = (TextView) view.findViewById(u.g.thread_ecomm_item_description);
        aVar.emj = (TextView) view.findViewById(u.g.thread_ecomm_item_forumname);
        aVar.emk = (TextView) view.findViewById(u.g.thread_ecomm_item_price);
    }
}
