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
    private TextView alp;
    private int apS = -1;
    private PersonInfoActivity cqE;
    private View csP;
    private ImageView csT;
    private ImageView csY;
    private ImageView ctd;
    private RelativeLayout cuc;
    private TextView cud;
    private TextView cue;
    private TextView cuf;
    private GridView cug;
    private TextView cuh;
    private TextView cui;
    private View cuj;
    private RelativeLayout cuk;
    private TextView cul;
    private ImageView cum;
    private View cun;
    private RelativeLayout cuo;
    private TextView cup;
    private TextView cuq;
    private ImageView cur;
    private View cus;
    private RelativeLayout cut;
    private TextView cuu;
    private TextView cuv;
    private int cuw;
    private boolean mIsHost;
    private View mRootView;

    public ad(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_relation_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csP = this.mRootView.findViewById(i.f.root_next);
        this.cuc = (RelativeLayout) this.mRootView.findViewById(i.f.gift);
        this.cuc.setOnClickListener(this.cqE);
        this.cud = (TextView) this.mRootView.findViewById(i.f.gift_num);
        this.cue = (TextView) this.mRootView.findViewById(i.f.new_gift_num);
        this.cuf = (TextView) this.mRootView.findViewById(i.f.gift_num_text);
        this.cug = (GridView) this.mRootView.findViewById(i.f.gift_grid);
        this.cuh = (TextView) this.mRootView.findViewById(i.f.no_gift_text);
        this.csT = (ImageView) this.mRootView.findViewById(i.f.arrow_top);
        this.cui = (TextView) this.mRootView.findViewById(i.f.give_gift);
        this.cui.setOnClickListener(this.cqE);
        this.cuj = this.mRootView.findViewById(i.f.gift_fans);
        this.cuk = (RelativeLayout) this.mRootView.findViewById(i.f.fans);
        this.cul = (TextView) this.mRootView.findViewById(i.f.fans_him);
        this.cum = (ImageView) this.mRootView.findViewById(i.f.fans_icon);
        this.alp = (TextView) this.mRootView.findViewById(i.f.fans_num);
        this.csY = (ImageView) this.mRootView.findViewById(i.f.arrow_middle);
        this.cuk.setOnClickListener(this.cqE);
        this.cun = this.mRootView.findViewById(i.f.addresslist_sep);
        this.cuo = (RelativeLayout) this.mRootView.findViewById(i.f.addresslist);
        this.cup = (TextView) this.mRootView.findViewById(i.f.addresslist_other);
        this.cuq = (TextView) this.mRootView.findViewById(i.f.addresslist_num);
        this.cur = (ImageView) this.mRootView.findViewById(i.f.arrow_addresslist);
        this.cuo.setOnClickListener(this.cqE);
        this.cus = this.mRootView.findViewById(i.f.fans_attention);
        this.cut = (RelativeLayout) this.mRootView.findViewById(i.f.attention);
        this.cuu = (TextView) this.mRootView.findViewById(i.f.attention_other);
        this.cuv = (TextView) this.mRootView.findViewById(i.f.attention_num);
        this.ctd = (ImageView) this.mRootView.findViewById(i.f.arrow_bottom);
        this.cut.setOnClickListener(this.cqE);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cuc.setVisibility(8);
        }
        oO();
    }

    public void fa(boolean z) {
        an.i(this.cum, i.e.icon_news_down_bar_one);
        if (z) {
            this.cum.setVisibility(0);
        } else {
            this.cum.setVisibility(8);
        }
    }

    public void jm(int i) {
        if (i <= 0) {
            this.cue.setVisibility(8);
            return;
        }
        this.cue.setVisibility(0);
        an.b(this.cue, i.c.top_msg_num_day, 1);
        if (i < 10) {
            this.cue.setText(String.valueOf(i));
            this.cuw = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cue.setText(String.valueOf(i));
            this.cuw = i.e.icon_news_head_prompt_two;
        } else {
            this.cue.setText("");
            this.cuw = i.e.icon_news_head_prompt_more;
        }
        an.i((View) this.cue, this.cuw);
    }

    public void ajy() {
        UserData userData = this.cqE.ajb().getUserData();
        k(userData);
        l(userData);
        j(userData);
        m(userData);
        oO();
    }

    private void j(UserData userData) {
        if (this.mIsHost && PersonInfoActivityConfig.IS_HAVE_ADDRESSLIST) {
            this.cun.setVisibility(0);
            this.cuo.setVisibility(0);
            this.cuq.setText("100个");
            return;
        }
        this.cun.setVisibility(8);
        this.cuo.setVisibility(8);
    }

    private void k(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.cud.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.cui.setVisibility(8);
                } else {
                    this.cui.setVisibility(0);
                }
                this.csT.setVisibility(8);
                this.cug.setVisibility(8);
                this.cuh.setVisibility(0);
                if (this.mIsHost) {
                    this.cuh.setText(i.h.no_gift_tip_host);
                    return;
                } else {
                    this.cuh.setText(i.h.no_gift_tip);
                    return;
                }
            }
            String cA = as.cA(giftNum);
            if (cA.contains("w") && cA.length() > 3) {
                this.cud.setTextSize(0, this.cqE.getResources().getDimensionPixelSize(i.d.ds48));
            }
            this.cud.setText(cA);
            this.cui.setVisibility(8);
            this.csT.setVisibility(0);
            this.cug.setVisibility(0);
            this.cuh.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.cui.setVisibility(8);
                this.csT.setVisibility(0);
                this.cug.setVisibility(0);
                this.cuh.setVisibility(8);
                return;
            }
            this.cug.setAdapter((ListAdapter) new a(gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void l(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.cul.setText(i.h.user_info_center_head_fans_name_text_g);
            } else {
                this.cul.setText(i.h.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.cul.setText(i.h.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.alp.setText("0");
                this.csY.setVisibility(8);
                an.b(this.alp, i.c.cp_cont_e, 1);
                return;
            }
            this.alp.setText(new StringBuilder().append(fansNum).toString());
            this.csY.setVisibility(0);
            an.b(this.alp, i.c.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void m(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.cuv.setText("0");
                this.ctd.setVisibility(8);
                an.b(this.cuv, i.c.cp_cont_e, 1);
                return;
            }
            this.cuv.setText(new StringBuilder().append(concern_num).toString());
            this.ctd.setVisibility(0);
            an.b(this.cuv, i.c.cp_cont_b, 1);
        }
    }

    public void oO() {
        if (this.apS != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apS = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.csP, i.c.cp_bg_line_d);
            an.i(this.cuc, i.e.personinfo_select_bg);
            an.b(this.cud, i.c.cp_cont_f, 1);
            an.b(this.cue, i.c.cp_cont_i, 1);
            an.b(this.cuf, i.c.cp_cont_d, 1);
            an.b(this.cuh, i.c.cp_cont_e, 1);
            an.i(this.csT, i.e.icon_dredge_arrow_r_n);
            an.i((View) this.cui, i.e.btn_blue_bg);
            an.b(this.cui, i.c.cp_cont_i, 1);
            an.j(this.cuj, i.c.cp_bg_line_b);
            an.i(this.cuk, i.e.personinfo_select_bg);
            an.b(this.cul, i.c.cp_cont_d, 1);
            an.i(this.csY, i.e.icon_dredge_arrow_r_n);
            an.j(this.cun, i.c.cp_bg_line_b);
            an.i(this.cuo, i.e.personinfo_select_bg);
            an.b(this.cup, i.c.cp_cont_d, 1);
            an.i(this.cur, i.e.icon_dredge_arrow_r_n);
            an.j(this.cus, i.c.cp_bg_line_b);
            an.i(this.cut, i.e.personinfo_select_bg);
            an.b(this.cuu, i.c.cp_cont_d, 1);
            an.i(this.ctd, i.e.icon_dredge_arrow_r_n);
        }
    }

    public TextView ajp() {
        return this.cui;
    }

    public RelativeLayout ajk() {
        return this.cuc;
    }

    public void ajl() {
        if (this.cuc != null) {
            this.cuc.setVisibility(8);
        }
        if (this.cuj != null) {
            this.cuj.setVisibility(8);
        }
    }

    public RelativeLayout ajr() {
        return this.cuk;
    }

    public RelativeLayout ajs() {
        return this.cut;
    }

    public RelativeLayout ajt() {
        return this.cuo;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private List<MyGift> cux;

        public a(List<MyGift> list) {
            this.cux = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cux == null) {
                return 0;
            }
            if (this.cux.size() <= 8) {
                return this.cux.size();
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
            View inflate = LayoutInflater.from(ad.this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_gift_icon, (ViewGroup) null);
            inflate.setLayoutParams(new AbsListView.LayoutParams(ad.this.cqE.getResources().getDimensionPixelSize(i.d.ds86), ad.this.cqE.getResources().getDimensionPixelSize(i.d.ds80)));
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(i.f.gift_icon);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView textView = (TextView) inflate.findViewById(i.f.gift_num);
            g(textView);
            MyGift myGift = this.cux.get(i);
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
