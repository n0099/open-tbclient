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
    private TextView amQ;
    private int arr = -1;
    private PersonInfoActivity ckP;
    private View cmY;
    private ImageView cnc;
    private ImageView cnh;
    private ImageView cnm;
    private View coA;
    private RelativeLayout coB;
    private TextView coC;
    private TextView coD;
    private int coE;
    private RelativeLayout cok;
    private TextView col;

    /* renamed from: com  reason: collision with root package name */
    private TextView f127com;
    private TextView con;
    private GridView coo;
    private TextView cop;
    private TextView coq;
    private View cor;
    private RelativeLayout cos;
    private TextView cot;
    private ImageView cou;
    private View cov;
    private RelativeLayout cow;
    private TextView cox;
    private TextView coy;
    private ImageView coz;
    private boolean mIsHost;
    private View mRootView;

    public ab(PersonInfoActivity personInfoActivity, boolean z) {
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_relation_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cmY = this.mRootView.findViewById(i.f.root_next);
        this.cok = (RelativeLayout) this.mRootView.findViewById(i.f.gift);
        this.cok.setOnClickListener(this.ckP);
        this.col = (TextView) this.mRootView.findViewById(i.f.gift_num);
        this.f127com = (TextView) this.mRootView.findViewById(i.f.new_gift_num);
        this.con = (TextView) this.mRootView.findViewById(i.f.gift_num_text);
        this.coo = (GridView) this.mRootView.findViewById(i.f.gift_grid);
        this.cop = (TextView) this.mRootView.findViewById(i.f.no_gift_text);
        this.cnc = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.coq = (TextView) this.mRootView.findViewById(i.f.give_gift);
        this.coq.setOnClickListener(this.ckP);
        this.cor = this.mRootView.findViewById(i.f.gift_fans);
        this.cos = (RelativeLayout) this.mRootView.findViewById(i.f.fans);
        this.cot = (TextView) this.mRootView.findViewById(i.f.fans_him);
        this.cou = (ImageView) this.mRootView.findViewById(i.f.fans_icon);
        this.amQ = (TextView) this.mRootView.findViewById(i.f.fans_num);
        this.cnh = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.cos.setOnClickListener(this.ckP);
        this.cov = this.mRootView.findViewById(i.f.addresslist_sep);
        this.cow = (RelativeLayout) this.mRootView.findViewById(i.f.addresslist);
        this.cox = (TextView) this.mRootView.findViewById(i.f.addresslist_other);
        this.coy = (TextView) this.mRootView.findViewById(i.f.addresslist_num);
        this.coz = (ImageView) this.mRootView.findViewById(i.f.arrow_addresslist);
        this.cow.setOnClickListener(this.ckP);
        this.coA = this.mRootView.findViewById(i.f.fans_attention);
        this.coB = (RelativeLayout) this.mRootView.findViewById(i.f.attention);
        this.coC = (TextView) this.mRootView.findViewById(i.f.attention_other);
        this.coD = (TextView) this.mRootView.findViewById(i.f.attention_num);
        this.cnm = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.coB.setOnClickListener(this.ckP);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cok.setVisibility(8);
        }
        oN();
    }

    public void eU(boolean z) {
        al.h(this.cou, i.e.icon_news_down_bar_one);
        if (z) {
            this.cou.setVisibility(0);
        } else {
            this.cou.setVisibility(8);
        }
    }

    public void jc(int i) {
        if (i <= 0) {
            this.f127com.setVisibility(8);
            return;
        }
        this.f127com.setVisibility(0);
        al.b(this.f127com, i.c.top_msg_num_day, 1);
        if (i < 10) {
            this.f127com.setText(String.valueOf(i));
            this.coE = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.f127com.setText(String.valueOf(i));
            this.coE = i.e.icon_news_head_prompt_two;
        } else {
            this.f127com.setText("");
            this.coE = i.e.icon_news_head_prompt_more;
        }
        al.h((View) this.f127com, this.coE);
    }

    public void ahA() {
        UserData userData = this.ckP.ahd().getUserData();
        j(userData);
        k(userData);
        i(userData);
        l(userData);
        oN();
    }

    private void i(UserData userData) {
        if (this.mIsHost && PersonInfoActivityConfig.IS_HAVE_ADDRESSLIST) {
            this.cov.setVisibility(0);
            this.cow.setVisibility(0);
            this.coy.setText("100个");
            return;
        }
        this.cov.setVisibility(8);
        this.cow.setVisibility(8);
    }

    private void j(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.col.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.coq.setVisibility(8);
                } else {
                    this.coq.setVisibility(0);
                }
                this.cnc.setVisibility(8);
                this.coo.setVisibility(8);
                this.cop.setVisibility(0);
                if (this.mIsHost) {
                    this.cop.setText(i.h.no_gift_tip_host);
                    return;
                } else {
                    this.cop.setText(i.h.no_gift_tip);
                    return;
                }
            }
            String cy = aq.cy(giftNum);
            if (cy.contains("w") && cy.length() > 3) {
                this.col.setTextSize(0, this.ckP.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.col.setText(cy);
            this.coq.setVisibility(8);
            this.cnc.setVisibility(0);
            this.coo.setVisibility(0);
            this.cop.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.coq.setVisibility(8);
                this.cnc.setVisibility(0);
                this.coo.setVisibility(0);
                this.cop.setVisibility(8);
                return;
            }
            this.coo.setAdapter((ListAdapter) new a(gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void k(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.cot.setText(i.h.user_info_center_head_fans_name_text_g);
            } else {
                this.cot.setText(i.h.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.cot.setText(i.h.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.amQ.setText("0");
                this.cnh.setVisibility(8);
                al.b(this.amQ, i.c.cp_cont_e, 1);
                return;
            }
            this.amQ.setText(new StringBuilder().append(fansNum).toString());
            this.cnh.setVisibility(0);
            al.b(this.amQ, i.c.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void l(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.coD.setText("0");
                this.cnm.setVisibility(8);
                al.b(this.coD, i.c.cp_cont_e, 1);
                return;
            }
            this.coD.setText(new StringBuilder().append(concern_num).toString());
            this.cnm.setVisibility(0);
            al.b(this.coD, i.c.cp_cont_b, 1);
        }
    }

    public void oN() {
        if (this.arr != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arr = TbadkCoreApplication.m411getInst().getSkinType();
            al.i(this.cmY, i.c.cp_bg_line_d);
            al.h(this.cok, i.e.personinfo_select_bg);
            al.b(this.col, i.c.cp_cont_f, 1);
            al.b(this.f127com, i.c.cp_cont_i, 1);
            al.b(this.con, i.c.cp_cont_d, 1);
            al.b(this.cop, i.c.cp_cont_e, 1);
            al.h(this.cnc, i.e.icon_dredge_arrow_r_n);
            al.h((View) this.coq, i.e.btn_blue_bg);
            al.b(this.coq, i.c.cp_cont_i, 1);
            al.i(this.cor, i.c.cp_bg_line_b);
            al.h(this.cos, i.e.personinfo_select_bg);
            al.b(this.cot, i.c.cp_cont_d, 1);
            al.h(this.cnh, i.e.icon_dredge_arrow_r_n);
            al.i(this.cov, i.c.cp_bg_line_b);
            al.h(this.cow, i.e.personinfo_select_bg);
            al.b(this.cox, i.c.cp_cont_d, 1);
            al.h(this.coz, i.e.icon_dredge_arrow_r_n);
            al.i(this.coA, i.c.cp_bg_line_b);
            al.h(this.coB, i.e.personinfo_select_bg);
            al.b(this.coC, i.c.cp_cont_d, 1);
            al.h(this.cnm, i.e.icon_dredge_arrow_r_n);
        }
    }

    public TextView ahr() {
        return this.coq;
    }

    public RelativeLayout ahm() {
        return this.cok;
    }

    public void ahn() {
        if (this.cok != null) {
            this.cok.setVisibility(8);
        }
        if (this.cor != null) {
            this.cor.setVisibility(8);
        }
    }

    public RelativeLayout aht() {
        return this.cos;
    }

    public RelativeLayout ahu() {
        return this.coB;
    }

    public RelativeLayout ahv() {
        return this.cow;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private List<MyGift> coF;

        public a(List<MyGift> list) {
            this.coF = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.coF == null) {
                return 0;
            }
            if (this.coF.size() <= 8) {
                return this.coF.size();
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
            View inflate = LayoutInflater.from(ab.this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_gift_icon, (ViewGroup) null);
            inflate.setLayoutParams(new AbsListView.LayoutParams(ab.this.ckP.getResources().getDimensionPixelSize(i.d.ds86), ab.this.ckP.getResources().getDimensionPixelSize(i.d.ds80)));
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(i.f.gift_icon);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView textView = (TextView) inflate.findViewById(i.f.gift_num);
            g(textView);
            MyGift myGift = this.coF.get(i);
            if (myGift != null) {
                headImageView.d(myGift.getGiftIcon(), 10, false);
                textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
            }
            return inflate;
        }

        private void g(TextView textView) {
            al.h((View) textView, i.e.personinfo_gift_num_bg);
            al.b(textView, i.c.cp_cont_g, 1);
        }
    }
}
