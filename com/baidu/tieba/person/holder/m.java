package com.baidu.tieba.person.holder;

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
    public int afy;
    public View euN;
    public LinearLayout euP;
    public View euV;
    public RelativeLayout evT;
    public TextView evU;
    public ImageView evV;
    public TextView evW;
    public RelativeLayout evX;
    public TextView evY;
    public TextView evZ;
    public View eva;
    public a ewA;
    private ViewStub ewB;
    public a ewC;
    public ImageView ewa;
    public RelativeLayout ewb;
    public TbImageView ewc;
    public TextView ewd;
    public TextView ewe;
    public TextView ewf;
    public RelativeLayout ewg;
    public TbImageView ewh;
    public TextView ewi;
    public TextView ewj;
    public TextView ewk;
    public RelativeLayout ewl;
    public TextView ewm;
    public TextView ewn;
    public TextView ewo;
    public RelativeLayout ewp;
    public TextView ewq;
    public TextView ewr;
    public TextView ews;
    public TbImageView ewt;
    public TbImageView ewu;
    public TbImageView ewv;
    public TbImageView eww;
    public TbImageView ewx;
    public TbImageView ewy;
    private ViewStub ewz;

    /* loaded from: classes.dex */
    public static class a {
        public ViewGroup ewD;
        public TbImageView ewE;
        public TextView ewF;
        public TextView ewG;
        public TextView ewH;
    }

    public m(View view) {
        super(view);
        this.euV = null;
        this.evT = null;
        this.evU = null;
        this.evV = null;
        this.evW = null;
        this.eva = null;
        this.euN = null;
        this.evX = null;
        this.evY = null;
        this.evZ = null;
        this.ewa = null;
        this.ewb = null;
        this.ewc = null;
        this.ewd = null;
        this.ewe = null;
        this.ewf = null;
        this.ewg = null;
        this.ewh = null;
        this.ewi = null;
        this.ewj = null;
        this.ewk = null;
        this.ewl = null;
        this.ewm = null;
        this.ewn = null;
        this.ewo = null;
        this.ewp = null;
        this.ewq = null;
        this.ewr = null;
        this.ews = null;
        this.ewt = null;
        this.ewu = null;
        this.ewv = null;
        this.eww = null;
        this.ewx = null;
        this.ewy = null;
        this.afy = 3;
        this.euP = (LinearLayout) view.findViewById(u.g.container);
        this.euV = view.findViewById(u.g.top_divider);
        this.eva = view.findViewById(u.g.head_divider);
        this.euN = view.findViewById(u.g.mid_divider);
        this.evT = (RelativeLayout) view.findViewById(u.g.thread_head);
        this.evU = (TextView) this.evT.findViewById(u.g.thread_head_title);
        this.evV = (ImageView) this.evT.findViewById(u.g.thread_head_arrow);
        this.evW = (TextView) this.evT.findViewById(u.g.thread_head_msg);
        this.evX = (RelativeLayout) view.findViewById(u.g.thread_none);
        this.evY = (TextView) this.evX.findViewById(u.g.thread_none_title);
        this.evZ = (TextView) this.evX.findViewById(u.g.thread_none_msg);
        this.ewa = (ImageView) this.evX.findViewById(u.g.thread_none_lock);
        this.ewb = (RelativeLayout) view.findViewById(u.g.pic_thread_item);
        this.ewc = (TbImageView) this.ewb.findViewById(u.g.pic_thread_item_img);
        this.ewd = (TextView) this.ewb.findViewById(u.g.pic_thread_item_title);
        this.ewe = (TextView) this.ewb.findViewById(u.g.pic_thread_item_content);
        this.ewf = (TextView) this.ewb.findViewById(u.g.pic_thread_item_forum_name);
        this.ewt = (TbImageView) this.ewb.findViewById(u.g.pic_thread_item_play_video_icon);
        this.ewv = (TbImageView) this.ewb.findViewById(u.g.pic_thread_item_play_video_icon);
        this.ewv = (TbImageView) this.ewb.findViewById(u.g.pic_thread_item_zhibo_icon);
        this.ewg = (RelativeLayout) view.findViewById(u.g.pic_thread_item1);
        this.ewh = (TbImageView) this.ewg.findViewById(u.g.pic_thread_item_img1);
        this.ewi = (TextView) this.ewg.findViewById(u.g.pic_thread_item_title1);
        this.ewj = (TextView) this.ewg.findViewById(u.g.pic_thread_item_content1);
        this.ewk = (TextView) this.ewg.findViewById(u.g.pic_thread_item_forum_name1);
        this.ewu = (TbImageView) this.ewg.findViewById(u.g.pic_thread_item_play_video_icon1);
        this.eww = (TbImageView) this.ewg.findViewById(u.g.pic_thread_item_zhibo_icon1);
        this.ewl = (RelativeLayout) view.findViewById(u.g.text_thread_item1);
        this.ewm = (TextView) this.ewl.findViewById(u.g.text_thread_item_title1);
        this.ewn = (TextView) this.ewl.findViewById(u.g.text_thread_item_content1);
        this.ewo = (TextView) this.ewl.findViewById(u.g.text_thread_item_forum_name1);
        this.ewx = (TbImageView) this.ewl.findViewById(u.g.text_thread_item_zhibo_icon1);
        this.ewp = (RelativeLayout) view.findViewById(u.g.text_thread_item2);
        this.ewq = (TextView) this.ewp.findViewById(u.g.text_thread_item_title2);
        this.ewr = (TextView) this.ewp.findViewById(u.g.text_thread_item_content2);
        this.ews = (TextView) this.ewp.findViewById(u.g.text_thread_item_forum_name2);
        this.ewy = (TbImageView) this.ewp.findViewById(u.g.text_thread_item_zhibo_icon2);
        this.ewz = (ViewStub) view.findViewById(u.g.thread_ecomm_item_1);
        this.ewB = (ViewStub) view.findViewById(u.g.thread_ecomm_item_2);
    }

    public void aOn() {
        if (this.ewA == null) {
            View inflate = this.ewz.inflate();
            this.ewA = new a();
            a(inflate, this.ewA);
        }
    }

    public void aOo() {
        if (this.ewC == null) {
            View inflate = this.ewB.inflate();
            this.ewC = new a();
            a(inflate, this.ewC);
        }
    }

    private void a(View view, a aVar) {
        aVar.ewD = (ViewGroup) view.findViewById(u.g.thread_ecomm_item);
        aVar.ewE = (TbImageView) view.findViewById(u.g.thread_ecomm_item_image);
        aVar.ewE.setScaleType(ImageView.ScaleType.FIT_XY);
        aVar.ewF = (TextView) view.findViewById(u.g.thread_ecomm_item_description);
        aVar.ewG = (TextView) view.findViewById(u.g.thread_ecomm_item_forumname);
        aVar.ewH = (TextView) view.findViewById(u.g.thread_ecomm_item_price);
    }
}
