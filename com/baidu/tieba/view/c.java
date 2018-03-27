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
    private TextView aHU;
    private List<a> aRq;
    private Context hAu;
    private LinearLayout hAv;
    private View hAw;
    private TextView hAx;
    private d hAy;
    private b hAz;
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
            this.hAu = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hAv = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aHU = (TextView) this.view.findViewById(d.g.title);
            this.hAw = this.view.findViewById(d.g.title_divide_line);
            this.aRq = new ArrayList();
            this.hAx = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hAu;
    }

    public ViewGroup aft() {
        return this.hAv;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hAy = dVar;
    }

    public d bEO() {
        return this.hAy;
    }

    public void dO(List<a> list) {
        if (list != null) {
            this.aRq = list;
            this.hAv.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hAv.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hAz = bVar;
    }

    public void onChangeSkinType() {
        aj.t(this.aHU, d.C0141d.cp_bg_line_d);
        aj.r(this.aHU, d.C0141d.cp_cont_j);
        aj.t(this.hAw, d.C0141d.cp_bg_line_c);
        aj.s(this.hAx, d.f.bg_bottom_up_list_dialog_item);
        aj.r(this.hAx, d.C0141d.cp_cont_f);
        if (this.aRq != null) {
            for (a aVar : this.aRq) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bEP() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aHU.setText(this.titleText);
        } else {
            this.aHU.setVisibility(8);
        }
        if (this.hAz != null) {
            this.hAx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hAz.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aUN;
        private View ehd;
        private c hAB;
        private int hAC;
        private int hAD;
        private InterfaceC0251c hAE;
        private boolean hAF;
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
            this.hAC = d.f.person_more_pop_item_bg_selector;
            this.hAD = 17;
            this.hAF = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hAE != null) {
                        a.this.hAE.onClick();
                    }
                    if (a.this.hAB != null && a.this.hAB.bEO() != null) {
                        a.this.hAB.bEO().lC(a.this.mId);
                    }
                }
            };
            this.aUN = str;
            this.hAB = cVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hAC = d.f.person_more_pop_item_bg_selector;
            this.hAD = 17;
            this.hAF = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hAE != null) {
                        a.this.hAE.onClick();
                    }
                    if (a.this.hAB != null && a.this.hAB.bEO() != null) {
                        a.this.hAB.bEO().lC(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aUN = str;
            this.hAB = cVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aUN = str;
            this.ry.setText(this.aUN);
        }

        public void a(InterfaceC0251c interfaceC0251c) {
            this.hAE = interfaceC0251c;
            initListener();
        }

        public void onChangeSkinType() {
            aj.s(this.ry, d.f.bg_bottom_up_list_dialog_item);
            aj.r(this.ry, d.C0141d.cp_cont_b);
            aj.t(this.ehd, d.C0141d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hAB != null && this.hAB.getContext() != null) {
                this.mView = LayoutInflater.from(this.hAB.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hAB.aft(), false);
                this.ry = (TextView) this.mView.findViewById(d.g.item_view);
                this.ry.setText(this.aUN);
                this.ry.setGravity(this.hAD);
                this.ehd = this.mView.findViewById(d.g.divider_line);
                if (this.hAF) {
                    this.ehd.setVisibility(0);
                } else {
                    this.ehd.setVisibility(8);
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
