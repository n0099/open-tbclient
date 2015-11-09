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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private TextView alu;
    private int arf = -1;
    private PersonInfoActivity csa;
    private View cul;
    private ImageView cup;
    private ImageView cuu;
    private ImageView cuz;
    private TextView cvA;
    private TextView cvB;
    private GridView cvC;
    private TextView cvD;
    private TextView cvE;
    private View cvF;
    private RelativeLayout cvG;
    private TextView cvH;
    private ImageView cvI;
    private View cvJ;
    private RelativeLayout cvK;
    private TextView cvL;
    private TextView cvM;
    private ImageView cvN;
    private View cvO;
    private RelativeLayout cvP;
    private TextView cvQ;
    private TextView cvR;
    private int cvS;
    private RelativeLayout cvy;
    private TextView cvz;
    private boolean mIsHost;
    private View mRootView;

    public ad(PersonInfoActivity personInfoActivity, boolean z) {
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_relation_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cul = this.mRootView.findViewById(i.f.root_next);
        this.cvy = (RelativeLayout) this.mRootView.findViewById(i.f.gift);
        this.cvy.setOnClickListener(this.csa);
        this.cvz = (TextView) this.mRootView.findViewById(i.f.gift_num);
        this.cvA = (TextView) this.mRootView.findViewById(i.f.new_gift_num);
        this.cvB = (TextView) this.mRootView.findViewById(i.f.gift_num_text);
        this.cvC = (GridView) this.mRootView.findViewById(i.f.gift_grid);
        this.cvD = (TextView) this.mRootView.findViewById(i.f.no_gift_text);
        this.cup = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.cvE = (TextView) this.mRootView.findViewById(i.f.give_gift);
        this.cvE.setOnClickListener(this.csa);
        this.cvF = this.mRootView.findViewById(i.f.gift_fans);
        this.cvG = (RelativeLayout) this.mRootView.findViewById(i.f.fans);
        this.cvH = (TextView) this.mRootView.findViewById(i.f.fans_him);
        this.cvI = (ImageView) this.mRootView.findViewById(i.f.fans_icon);
        this.alu = (TextView) this.mRootView.findViewById(i.f.fans_num);
        this.cuu = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.cvG.setOnClickListener(this.csa);
        this.cvJ = this.mRootView.findViewById(i.f.addresslist_sep);
        this.cvK = (RelativeLayout) this.mRootView.findViewById(i.f.addresslist);
        this.cvL = (TextView) this.mRootView.findViewById(i.f.addresslist_other);
        this.cvM = (TextView) this.mRootView.findViewById(i.f.addresslist_num);
        this.cvN = (ImageView) this.mRootView.findViewById(i.f.arrow_addresslist);
        this.cvK.setOnClickListener(this.csa);
        this.cvO = this.mRootView.findViewById(i.f.fans_attention);
        this.cvP = (RelativeLayout) this.mRootView.findViewById(i.f.attention);
        this.cvQ = (TextView) this.mRootView.findViewById(i.f.attention_other);
        this.cvR = (TextView) this.mRootView.findViewById(i.f.attention_num);
        this.cuz = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cvP.setOnClickListener(this.csa);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cvy.setVisibility(8);
        }
        oP();
    }

    public void fd(boolean z) {
        an.i(this.cvI, i.e.icon_news_down_bar_one);
        if (z) {
            this.cvI.setVisibility(0);
        } else {
            this.cvI.setVisibility(8);
        }
    }

    public void jA(int i) {
        if (i <= 0) {
            this.cvA.setVisibility(8);
            return;
        }
        this.cvA.setVisibility(0);
        an.b(this.cvA, i.c.top_msg_num_day, 1);
        if (i < 10) {
            this.cvA.setText(String.valueOf(i));
            this.cvS = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cvA.setText(String.valueOf(i));
            this.cvS = i.e.icon_news_head_prompt_two;
        } else {
            this.cvA.setText("");
            this.cvS = i.e.icon_news_head_prompt_more;
        }
        an.i((View) this.cvA, this.cvS);
    }

    public void ake() {
        UserData userData = this.csa.ajH().getUserData();
        k(userData);
        l(userData);
        j(userData);
        m(userData);
        oP();
    }

    private void j(UserData userData) {
        if (this.mIsHost && PersonInfoActivityConfig.IS_HAVE_ADDRESSLIST) {
            this.cvJ.setVisibility(0);
            this.cvK.setVisibility(0);
            this.cvM.setText("100个");
            return;
        }
        this.cvJ.setVisibility(8);
        this.cvK.setVisibility(8);
    }

    private void k(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.cvz.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.cvE.setVisibility(8);
                } else {
                    this.cvE.setVisibility(0);
                }
                this.cup.setVisibility(8);
                this.cvC.setVisibility(8);
                this.cvD.setVisibility(0);
                if (this.mIsHost) {
                    this.cvD.setText(i.h.no_gift_tip_host);
                    return;
                } else {
                    this.cvD.setText(i.h.no_gift_tip);
                    return;
                }
            }
            String cA = as.cA(giftNum);
            if (cA.contains("w") && cA.length() > 3) {
                this.cvz.setTextSize(0, this.csa.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cvz.setText(cA);
            this.cvE.setVisibility(8);
            this.cup.setVisibility(0);
            this.cvC.setVisibility(0);
            this.cvD.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.cvE.setVisibility(8);
                this.cup.setVisibility(0);
                this.cvC.setVisibility(0);
                this.cvD.setVisibility(8);
                return;
            }
            this.cvC.setAdapter((ListAdapter) new a(gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void l(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.cvH.setText(i.h.user_info_center_head_fans_name_text_g);
            } else {
                this.cvH.setText(i.h.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.cvH.setText(i.h.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.alu.setText("0");
                this.cuu.setVisibility(8);
                an.b(this.alu, i.c.cp_cont_e, 1);
                return;
            }
            this.alu.setText(new StringBuilder().append(fansNum).toString());
            this.cuu.setVisibility(0);
            an.b(this.alu, i.c.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void m(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.cvR.setText("0");
                this.cuz.setVisibility(8);
                an.b(this.cvR, i.c.cp_cont_e, 1);
                return;
            }
            this.cvR.setText(new StringBuilder().append(concern_num).toString());
            this.cuz.setVisibility(0);
            an.b(this.cvR, i.c.cp_cont_b, 1);
        }
    }

    public void oP() {
        if (this.arf != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arf = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.cul, i.c.cp_bg_line_d);
            an.i(this.cvy, i.e.personinfo_select_bg);
            an.b(this.cvz, i.c.cp_cont_f, 1);
            an.b(this.cvA, i.c.cp_cont_i, 1);
            an.b(this.cvB, i.c.cp_cont_d, 1);
            an.b(this.cvD, i.c.cp_cont_e, 1);
            an.i(this.cup, i.e.icon_dredge_arrow_r_n);
            an.i((View) this.cvE, i.e.btn_blue_bg);
            an.b(this.cvE, i.c.cp_cont_i, 1);
            an.j(this.cvF, i.c.cp_bg_line_b);
            an.i(this.cvG, i.e.personinfo_select_bg);
            an.b(this.cvH, i.c.cp_cont_d, 1);
            an.i(this.cuu, i.e.icon_dredge_arrow_r_n);
            an.j(this.cvJ, i.c.cp_bg_line_b);
            an.i(this.cvK, i.e.personinfo_select_bg);
            an.b(this.cvL, i.c.cp_cont_d, 1);
            an.i(this.cvN, i.e.icon_dredge_arrow_r_n);
            an.j(this.cvO, i.c.cp_bg_line_b);
            an.i(this.cvP, i.e.personinfo_select_bg);
            an.b(this.cvQ, i.c.cp_cont_d, 1);
            an.i(this.cuz, i.e.icon_dredge_arrow_r_n);
        }
    }

    public TextView ajV() {
        return this.cvE;
    }

    public RelativeLayout ajQ() {
        return this.cvy;
    }

    public void ajR() {
        if (this.cvy != null) {
            this.cvy.setVisibility(8);
        }
        if (this.cvF != null) {
            this.cvF.setVisibility(8);
        }
    }

    public RelativeLayout ajX() {
        return this.cvG;
    }

    public RelativeLayout ajY() {
        return this.cvP;
    }

    public RelativeLayout ajZ() {
        return this.cvK;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private List<MyGift> cvT;

        public a(List<MyGift> list) {
            this.cvT = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cvT == null) {
                return 0;
            }
            if (this.cvT.size() <= 8) {
                return this.cvT.size();
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
            View inflate = LayoutInflater.from(ad.this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_gift_icon, (ViewGroup) null);
            inflate.setLayoutParams(new AbsListView.LayoutParams(ad.this.csa.getResources().getDimensionPixelSize(i.d.ds86), ad.this.csa.getResources().getDimensionPixelSize(i.d.ds80)));
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(i.f.gift_icon);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView textView = (TextView) inflate.findViewById(i.f.gift_num);
            g(textView);
            MyGift myGift = this.cvT.get(i);
            if (myGift != null) {
                headImageView.d(myGift.getGiftIcon(), 10, false);
                textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
            }
            return inflate;
        }

        private void g(TextView textView) {
            an.i((View) textView, i.e.personinfo_gift_num_bg);
            an.b(textView, i.c.cp_cont_g, 1);
        }
    }
}
