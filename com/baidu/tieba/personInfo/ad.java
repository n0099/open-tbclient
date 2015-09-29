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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private TextView alo;
    private int apR = -1;
    private PersonInfoActivity cqt;
    private View csE;
    private ImageView csI;
    private ImageView csN;
    private ImageView csS;
    private RelativeLayout ctR;
    private TextView ctS;
    private TextView ctT;
    private TextView ctU;
    private GridView ctV;
    private TextView ctW;
    private TextView ctX;
    private View ctY;
    private RelativeLayout ctZ;
    private TextView cua;
    private ImageView cub;
    private View cuc;
    private RelativeLayout cud;
    private TextView cue;
    private TextView cuf;
    private ImageView cug;
    private View cuh;
    private RelativeLayout cui;
    private TextView cuj;
    private TextView cuk;
    private int cul;
    private boolean mIsHost;
    private View mRootView;

    public ad(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_relation_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csE = this.mRootView.findViewById(i.f.root_next);
        this.ctR = (RelativeLayout) this.mRootView.findViewById(i.f.gift);
        this.ctR.setOnClickListener(this.cqt);
        this.ctS = (TextView) this.mRootView.findViewById(i.f.gift_num);
        this.ctT = (TextView) this.mRootView.findViewById(i.f.new_gift_num);
        this.ctU = (TextView) this.mRootView.findViewById(i.f.gift_num_text);
        this.ctV = (GridView) this.mRootView.findViewById(i.f.gift_grid);
        this.ctW = (TextView) this.mRootView.findViewById(i.f.no_gift_text);
        this.csI = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.ctX = (TextView) this.mRootView.findViewById(i.f.give_gift);
        this.ctX.setOnClickListener(this.cqt);
        this.ctY = this.mRootView.findViewById(i.f.gift_fans);
        this.ctZ = (RelativeLayout) this.mRootView.findViewById(i.f.fans);
        this.cua = (TextView) this.mRootView.findViewById(i.f.fans_him);
        this.cub = (ImageView) this.mRootView.findViewById(i.f.fans_icon);
        this.alo = (TextView) this.mRootView.findViewById(i.f.fans_num);
        this.csN = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.ctZ.setOnClickListener(this.cqt);
        this.cuc = this.mRootView.findViewById(i.f.addresslist_sep);
        this.cud = (RelativeLayout) this.mRootView.findViewById(i.f.addresslist);
        this.cue = (TextView) this.mRootView.findViewById(i.f.addresslist_other);
        this.cuf = (TextView) this.mRootView.findViewById(i.f.addresslist_num);
        this.cug = (ImageView) this.mRootView.findViewById(i.f.arrow_addresslist);
        this.cud.setOnClickListener(this.cqt);
        this.cuh = this.mRootView.findViewById(i.f.fans_attention);
        this.cui = (RelativeLayout) this.mRootView.findViewById(i.f.attention);
        this.cuj = (TextView) this.mRootView.findViewById(i.f.attention_other);
        this.cuk = (TextView) this.mRootView.findViewById(i.f.attention_num);
        this.csS = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cui.setOnClickListener(this.cqt);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.ctR.setVisibility(8);
        }
        oO();
    }

    public void fa(boolean z) {
        am.i(this.cub, i.e.icon_news_down_bar_one);
        if (z) {
            this.cub.setVisibility(0);
        } else {
            this.cub.setVisibility(8);
        }
    }

    public void jm(int i) {
        if (i <= 0) {
            this.ctT.setVisibility(8);
            return;
        }
        this.ctT.setVisibility(0);
        am.b(this.ctT, i.c.top_msg_num_day, 1);
        if (i < 10) {
            this.ctT.setText(String.valueOf(i));
            this.cul = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.ctT.setText(String.valueOf(i));
            this.cul = i.e.icon_news_head_prompt_two;
        } else {
            this.ctT.setText("");
            this.cul = i.e.icon_news_head_prompt_more;
        }
        am.i((View) this.ctT, this.cul);
    }

    public void ajC() {
        UserData userData = this.cqt.ajf().getUserData();
        k(userData);
        l(userData);
        j(userData);
        m(userData);
        oO();
    }

    private void j(UserData userData) {
        if (this.mIsHost && PersonInfoActivityConfig.IS_HAVE_ADDRESSLIST) {
            this.cuc.setVisibility(0);
            this.cud.setVisibility(0);
            this.cuf.setText("100个");
            return;
        }
        this.cuc.setVisibility(8);
        this.cud.setVisibility(8);
    }

    private void k(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.ctS.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.ctX.setVisibility(8);
                } else {
                    this.ctX.setVisibility(0);
                }
                this.csI.setVisibility(8);
                this.ctV.setVisibility(8);
                this.ctW.setVisibility(0);
                if (this.mIsHost) {
                    this.ctW.setText(i.h.no_gift_tip_host);
                    return;
                } else {
                    this.ctW.setText(i.h.no_gift_tip);
                    return;
                }
            }
            String cA = ar.cA(giftNum);
            if (cA.contains("w") && cA.length() > 3) {
                this.ctS.setTextSize(0, this.cqt.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.ctS.setText(cA);
            this.ctX.setVisibility(8);
            this.csI.setVisibility(0);
            this.ctV.setVisibility(0);
            this.ctW.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.ctX.setVisibility(8);
                this.csI.setVisibility(0);
                this.ctV.setVisibility(0);
                this.ctW.setVisibility(8);
                return;
            }
            this.ctV.setAdapter((ListAdapter) new a(gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void l(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.cua.setText(i.h.user_info_center_head_fans_name_text_g);
            } else {
                this.cua.setText(i.h.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.cua.setText(i.h.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.alo.setText("0");
                this.csN.setVisibility(8);
                am.b(this.alo, i.c.cp_cont_e, 1);
                return;
            }
            this.alo.setText(new StringBuilder().append(fansNum).toString());
            this.csN.setVisibility(0);
            am.b(this.alo, i.c.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void m(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.cuk.setText("0");
                this.csS.setVisibility(8);
                am.b(this.cuk, i.c.cp_cont_e, 1);
                return;
            }
            this.cuk.setText(new StringBuilder().append(concern_num).toString());
            this.csS.setVisibility(0);
            am.b(this.cuk, i.c.cp_cont_b, 1);
        }
    }

    public void oO() {
        if (this.apR != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apR = TbadkCoreApplication.m411getInst().getSkinType();
            am.j(this.csE, i.c.cp_bg_line_d);
            am.i(this.ctR, i.e.personinfo_select_bg);
            am.b(this.ctS, i.c.cp_cont_f, 1);
            am.b(this.ctT, i.c.cp_cont_i, 1);
            am.b(this.ctU, i.c.cp_cont_d, 1);
            am.b(this.ctW, i.c.cp_cont_e, 1);
            am.i(this.csI, i.e.icon_dredge_arrow_r_n);
            am.i((View) this.ctX, i.e.btn_blue_bg);
            am.b(this.ctX, i.c.cp_cont_i, 1);
            am.j(this.ctY, i.c.cp_bg_line_b);
            am.i(this.ctZ, i.e.personinfo_select_bg);
            am.b(this.cua, i.c.cp_cont_d, 1);
            am.i(this.csN, i.e.icon_dredge_arrow_r_n);
            am.j(this.cuc, i.c.cp_bg_line_b);
            am.i(this.cud, i.e.personinfo_select_bg);
            am.b(this.cue, i.c.cp_cont_d, 1);
            am.i(this.cug, i.e.icon_dredge_arrow_r_n);
            am.j(this.cuh, i.c.cp_bg_line_b);
            am.i(this.cui, i.e.personinfo_select_bg);
            am.b(this.cuj, i.c.cp_cont_d, 1);
            am.i(this.csS, i.e.icon_dredge_arrow_r_n);
        }
    }

    public TextView ajt() {
        return this.ctX;
    }

    public RelativeLayout ajo() {
        return this.ctR;
    }

    public void ajp() {
        if (this.ctR != null) {
            this.ctR.setVisibility(8);
        }
        if (this.ctY != null) {
            this.ctY.setVisibility(8);
        }
    }

    public RelativeLayout ajv() {
        return this.ctZ;
    }

    public RelativeLayout ajw() {
        return this.cui;
    }

    public RelativeLayout ajx() {
        return this.cud;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private List<MyGift> cum;

        public a(List<MyGift> list) {
            this.cum = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cum == null) {
                return 0;
            }
            if (this.cum.size() <= 8) {
                return this.cum.size();
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
            View inflate = LayoutInflater.from(ad.this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_gift_icon, (ViewGroup) null);
            inflate.setLayoutParams(new AbsListView.LayoutParams(ad.this.cqt.getResources().getDimensionPixelSize(i.d.ds86), ad.this.cqt.getResources().getDimensionPixelSize(i.d.ds80)));
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(i.f.gift_icon);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView textView = (TextView) inflate.findViewById(i.f.gift_num);
            g(textView);
            MyGift myGift = this.cum.get(i);
            if (myGift != null) {
                headImageView.d(myGift.getGiftIcon(), 10, false);
                textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
            }
            return inflate;
        }

        private void g(TextView textView) {
            am.i((View) textView, i.e.personinfo_gift_num_bg);
            am.b(textView, i.c.cp_cont_g, 1);
        }
    }
}
