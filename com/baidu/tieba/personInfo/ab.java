package com.baidu.tieba.personInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class ab {
    private int apH = -1;
    private PersonInfoActivity cjU;
    private View clV;
    private ImageView clZ;
    private ImageView cmf;
    private ImageView cmk;
    private RelativeLayout cnA;
    private TextView cnB;
    private TextView cnC;
    private int cnD;
    private RelativeLayout cni;
    private TextView cnj;
    private TextView cnk;
    private TextView cnl;
    private GridView cnm;
    private TextView cnn;
    private TextView cno;
    private View cnp;
    private RelativeLayout cnq;
    private TextView cnr;
    private ImageView cns;
    private TextView cnt;
    private View cnu;
    private RelativeLayout cnv;
    private TextView cnw;
    private TextView cnx;
    private ImageView cny;
    private View cnz;
    private boolean mIsHost;
    private View mRootView;

    public ab(PersonInfoActivity personInfoActivity, boolean z) {
        this.cjU = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_relation_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.clV = this.mRootView.findViewById(i.f.root_next);
        this.cni = (RelativeLayout) this.mRootView.findViewById(i.f.gift);
        this.cni.setOnClickListener(this.cjU);
        this.cnj = (TextView) this.mRootView.findViewById(i.f.gift_num);
        this.cnk = (TextView) this.mRootView.findViewById(i.f.new_gift_num);
        this.cnl = (TextView) this.mRootView.findViewById(i.f.gift_num_text);
        this.cnm = (GridView) this.mRootView.findViewById(i.f.gift_grid);
        this.cnn = (TextView) this.mRootView.findViewById(i.f.no_gift_text);
        this.clZ = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.cno = (TextView) this.mRootView.findViewById(i.f.give_gift);
        this.cno.setOnClickListener(this.cjU);
        this.cnp = this.mRootView.findViewById(i.f.gift_fans);
        this.cnq = (RelativeLayout) this.mRootView.findViewById(i.f.fans);
        this.cnr = (TextView) this.mRootView.findViewById(i.f.fans_him);
        this.cns = (ImageView) this.mRootView.findViewById(i.f.fans_icon);
        this.cnt = (TextView) this.mRootView.findViewById(i.f.fans_num);
        this.cmf = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.cnq.setOnClickListener(this.cjU);
        this.cnu = this.mRootView.findViewById(i.f.addresslist_sep);
        this.cnv = (RelativeLayout) this.mRootView.findViewById(i.f.addresslist);
        this.cnw = (TextView) this.mRootView.findViewById(i.f.addresslist_other);
        this.cnx = (TextView) this.mRootView.findViewById(i.f.addresslist_num);
        this.cny = (ImageView) this.mRootView.findViewById(i.f.arrow_addresslist);
        this.cnv.setOnClickListener(this.cjU);
        this.cnz = this.mRootView.findViewById(i.f.fans_attention);
        this.cnA = (RelativeLayout) this.mRootView.findViewById(i.f.attention);
        this.cnB = (TextView) this.mRootView.findViewById(i.f.attention_other);
        this.cnC = (TextView) this.mRootView.findViewById(i.f.attention_num);
        this.cmk = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cnA.setOnClickListener(this.cjU);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cni.setVisibility(8);
        }
        oQ();
    }

    public void eJ(boolean z) {
        al.i(this.cns, i.e.icon_news_down_bar_one);
        if (z) {
            this.cns.setVisibility(0);
        } else {
            this.cns.setVisibility(8);
        }
    }

    public void iP(int i) {
        if (i <= 0) {
            this.cnk.setVisibility(8);
            return;
        }
        this.cnk.setVisibility(0);
        al.b(this.cnk, i.c.top_msg_num_day, 1);
        if (i < 10) {
            this.cnk.setText(String.valueOf(i));
            this.cnD = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cnk.setText(String.valueOf(i));
            this.cnD = i.e.icon_news_head_prompt_two;
        } else {
            this.cnk.setText("");
            this.cnD = i.e.icon_news_head_prompt_more;
        }
        al.i((View) this.cnk, this.cnD);
    }

    public void ahi() {
        UserData userData = this.cjU.agL().getUserData();
        j(userData);
        k(userData);
        i(userData);
        l(userData);
        oQ();
    }

    private void i(UserData userData) {
        if (this.mIsHost && PersonInfoActivityConfig.IS_HAVE_ADDRESSLIST) {
            this.cnu.setVisibility(0);
            this.cnv.setVisibility(0);
            this.cnx.setText("100个");
            return;
        }
        this.cnu.setVisibility(8);
        this.cnv.setVisibility(8);
    }

    private void j(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.cnj.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.cno.setVisibility(8);
                } else {
                    this.cno.setVisibility(0);
                }
                this.clZ.setVisibility(8);
                this.cnm.setVisibility(8);
                this.cnn.setVisibility(0);
                if (this.mIsHost) {
                    this.cnn.setText(i.C0057i.no_gift_tip_host);
                    return;
                } else {
                    this.cnn.setText(i.C0057i.no_gift_tip);
                    return;
                }
            }
            String ct = aq.ct(giftNum);
            if (ct.contains("w") && ct.length() > 3) {
                this.cnj.setTextSize(0, this.cjU.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cnj.setText(ct);
            this.cno.setVisibility(8);
            this.clZ.setVisibility(0);
            this.cnm.setVisibility(0);
            this.cnn.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.cno.setVisibility(8);
                this.clZ.setVisibility(0);
                this.cnm.setVisibility(0);
                this.cnn.setVisibility(8);
                return;
            }
            this.cnm.setAdapter((ListAdapter) new a(gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void k(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.cnr.setText(i.C0057i.user_info_center_head_fans_name_text_g);
            } else {
                this.cnr.setText(i.C0057i.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.cnr.setText(i.C0057i.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.cnt.setText("0");
                this.cmf.setVisibility(8);
                al.b(this.cnt, i.c.cp_cont_e, 1);
                return;
            }
            this.cnt.setText(new StringBuilder().append(fansNum).toString());
            this.cmf.setVisibility(0);
            al.b(this.cnt, i.c.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void l(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.cnC.setText("0");
                this.cmk.setVisibility(8);
                al.b(this.cnC, i.c.cp_cont_e, 1);
                return;
            }
            this.cnC.setText(new StringBuilder().append(concern_num).toString());
            this.cmk.setVisibility(0);
            al.b(this.cnC, i.c.cp_cont_b, 1);
        }
    }

    public void oQ() {
        if (this.apH != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apH = TbadkCoreApplication.m411getInst().getSkinType();
            al.j(this.clV, i.c.cp_bg_line_d);
            al.i(this.cni, i.e.personinfo_select_bg);
            al.b(this.cnj, i.c.cp_cont_f, 1);
            al.b(this.cnk, i.c.cp_cont_i, 1);
            al.b(this.cnl, i.c.cp_cont_d, 1);
            al.b(this.cnn, i.c.cp_cont_e, 1);
            al.i(this.clZ, i.e.icon_dredge_arrow_r_n);
            al.i((View) this.cno, i.e.btn_blue_bg);
            al.b(this.cno, i.c.cp_cont_i, 1);
            al.j(this.cnp, i.c.cp_bg_line_b);
            al.i(this.cnq, i.e.personinfo_select_bg);
            al.b(this.cnr, i.c.cp_cont_d, 1);
            al.i(this.cmf, i.e.icon_dredge_arrow_r_n);
            al.j(this.cnu, i.c.cp_bg_line_b);
            al.i(this.cnv, i.e.personinfo_select_bg);
            al.b(this.cnw, i.c.cp_cont_d, 1);
            al.i(this.cny, i.e.icon_dredge_arrow_r_n);
            al.j(this.cnz, i.c.cp_bg_line_b);
            al.i(this.cnA, i.e.personinfo_select_bg);
            al.b(this.cnB, i.c.cp_cont_d, 1);
            al.i(this.cmk, i.e.icon_dredge_arrow_r_n);
        }
    }

    public TextView agZ() {
        return this.cno;
    }

    public RelativeLayout agU() {
        return this.cni;
    }

    public void agV() {
        if (this.cni != null) {
            this.cni.setVisibility(8);
        }
        if (this.cnp != null) {
            this.cnp.setVisibility(8);
        }
    }

    public RelativeLayout ahb() {
        return this.cnq;
    }

    public RelativeLayout ahc() {
        return this.cnA;
    }

    public RelativeLayout ahd() {
        return this.cnv;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private List<MyGift> cnE;

        public a(List<MyGift> list) {
            this.cnE = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cnE == null) {
                return 0;
            }
            if (this.cnE.size() <= 8) {
                return this.cnE.size();
            }
            return 8;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0074: INVOKE  (r0v9 int A[REMOVE]) = (r2v8 com.baidu.tbadk.data.MyGift) type: VIRTUAL call: com.baidu.tbadk.data.MyGift.getGiftNum():int)] */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(ab.this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_gift_icon, (ViewGroup) null);
            inflate.setLayoutParams(new AbsListView.LayoutParams(ab.this.cjU.getResources().getDimensionPixelSize(i.d.ds86), ab.this.cjU.getResources().getDimensionPixelSize(i.d.ds80)));
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(i.f.gift_icon);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView textView = (TextView) inflate.findViewById(i.f.gift_num);
            g(textView);
            MyGift myGift = this.cnE.get(i);
            if (myGift != null) {
                headImageView.d(myGift.getGiftIcon(), 10, false);
                textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
            }
            return inflate;
        }

        private void g(TextView textView) {
            al.i((View) textView, i.e.personinfo_gift_num_bg);
            al.b(textView, i.c.cp_cont_g, 1);
        }
    }
}
