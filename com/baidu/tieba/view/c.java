package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private TextView aHT;
    private List<a> aRo;
    private d hAa;
    private b hAb;
    private Context hzW;
    private LinearLayout hzX;
    private View hzY;
    private TextView hzZ;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* renamed from: com.baidu.tieba.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0251c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void lC(int i);
    }

    public c(Context context) {
        if (context != null) {
            this.hzW = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hzX = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aHT = (TextView) this.view.findViewById(d.g.title);
            this.hzY = this.view.findViewById(d.g.title_divide_line);
            this.aRo = new ArrayList();
            this.hzZ = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hzW;
    }

    public ViewGroup afs() {
        return this.hzX;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hAa = dVar;
    }

    public d bEJ() {
        return this.hAa;
    }

    public void dO(List<a> list) {
        if (list != null) {
            this.aRo = list;
            this.hzX.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hzX.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hAb = bVar;
    }

    public void onChangeSkinType() {
        aj.t(this.aHT, d.C0141d.cp_bg_line_d);
        aj.r(this.aHT, d.C0141d.cp_cont_j);
        aj.t(this.hzY, d.C0141d.cp_bg_line_c);
        aj.s(this.hzZ, d.f.bg_bottom_up_list_dialog_item);
        aj.r(this.hzZ, d.C0141d.cp_cont_f);
        if (this.aRo != null) {
            for (a aVar : this.aRo) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bEK() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aHT.setText(this.titleText);
        } else {
            this.aHT.setVisibility(8);
        }
        if (this.hAb != null) {
            this.hzZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hAb.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aUL;
        private View egN;
        private c hAd;
        private int hAe;
        private int hAf;
        private InterfaceC0251c hAg;
        private boolean hAh;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private View mView;
        private TextView ry;

        public a(c cVar) {
            this(null, cVar);
        }

        public a(String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hAe = d.f.person_more_pop_item_bg_selector;
            this.hAf = 17;
            this.hAh = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hAg != null) {
                        a.this.hAg.onClick();
                    }
                    if (a.this.hAd != null && a.this.hAd.bEJ() != null) {
                        a.this.hAd.bEJ().lC(a.this.mId);
                    }
                }
            };
            this.aUL = str;
            this.hAd = cVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hAe = d.f.person_more_pop_item_bg_selector;
            this.hAf = 17;
            this.hAh = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hAg != null) {
                        a.this.hAg.onClick();
                    }
                    if (a.this.hAd != null && a.this.hAd.bEJ() != null) {
                        a.this.hAd.bEJ().lC(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aUL = str;
            this.hAd = cVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aUL = str;
            this.ry.setText(this.aUL);
        }

        public void a(InterfaceC0251c interfaceC0251c) {
            this.hAg = interfaceC0251c;
            initListener();
        }

        public void onChangeSkinType() {
            aj.s(this.ry, d.f.bg_bottom_up_list_dialog_item);
            aj.r(this.ry, d.C0141d.cp_cont_b);
            aj.t(this.egN, d.C0141d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hAd != null && this.hAd.getContext() != null) {
                this.mView = LayoutInflater.from(this.hAd.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hAd.afs(), false);
                this.ry = (TextView) this.mView.findViewById(d.g.item_view);
                this.ry.setText(this.aUL);
                this.ry.setGravity(this.hAf);
                this.egN = this.mView.findViewById(d.g.divider_line);
                if (this.hAh) {
                    this.egN.setVisibility(0);
                } else {
                    this.egN.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.ry != null) {
                this.ry.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
