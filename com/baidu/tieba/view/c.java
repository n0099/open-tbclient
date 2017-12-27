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
    private TextView aGK;
    private List<a> aQa;
    private Context hIC;
    private LinearLayout hID;
    private View hIE;
    private TextView hIF;
    private d hIG;
    private b hIH;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* renamed from: com.baidu.tieba.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0168c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void lD(int i);
    }

    public c(Context context) {
        if (context != null) {
            this.hIC = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hID = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aGK = (TextView) this.view.findViewById(d.g.title);
            this.hIE = this.view.findViewById(d.g.title_divide_line);
            this.aQa = new ArrayList();
            this.hIF = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hIC;
    }

    public ViewGroup aex() {
        return this.hID;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hIG = dVar;
    }

    public d bKs() {
        return this.hIG;
    }

    public void dZ(List<a> list) {
        if (list != null) {
            this.aQa = list;
            this.hID.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hID.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hIH = bVar;
    }

    public void onChangeSkinType() {
        aj.t(this.aGK, d.C0108d.cp_bg_line_d);
        aj.r(this.aGK, d.C0108d.cp_cont_j);
        aj.t(this.hIE, d.C0108d.cp_bg_line_c);
        aj.s(this.hIF, d.f.bg_bottom_up_list_dialog_item);
        aj.r(this.hIF, d.C0108d.cp_cont_f);
        if (this.aQa != null) {
            for (a aVar : this.aQa) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bKt() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aGK.setText(this.titleText);
        } else {
            this.aGK.setVisibility(8);
        }
        if (this.hIH != null) {
            this.hIF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hIH.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aTq;
        private View ebi;
        private c hIJ;
        private int hIK;
        private int hIL;
        private InterfaceC0168c hIM;
        private boolean hIN;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private View mView;
        private TextView rz;

        public a(c cVar) {
            this(null, cVar);
        }

        public a(String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hIK = d.f.person_more_pop_item_bg_selector;
            this.hIL = 17;
            this.hIN = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hIM != null) {
                        a.this.hIM.onClick();
                    }
                    if (a.this.hIJ != null && a.this.hIJ.bKs() != null) {
                        a.this.hIJ.bKs().lD(a.this.mId);
                    }
                }
            };
            this.aTq = str;
            this.hIJ = cVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hIK = d.f.person_more_pop_item_bg_selector;
            this.hIL = 17;
            this.hIN = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hIM != null) {
                        a.this.hIM.onClick();
                    }
                    if (a.this.hIJ != null && a.this.hIJ.bKs() != null) {
                        a.this.hIJ.bKs().lD(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aTq = str;
            this.hIJ = cVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aTq = str;
            this.rz.setText(this.aTq);
        }

        public void a(InterfaceC0168c interfaceC0168c) {
            this.hIM = interfaceC0168c;
            initListener();
        }

        public void onChangeSkinType() {
            aj.s(this.rz, d.f.bg_bottom_up_list_dialog_item);
            aj.r(this.rz, d.C0108d.cp_cont_b);
            aj.t(this.ebi, d.C0108d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hIJ != null && this.hIJ.getContext() != null) {
                this.mView = LayoutInflater.from(this.hIJ.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hIJ.aex(), false);
                this.rz = (TextView) this.mView.findViewById(d.g.item_view);
                this.rz.setText(this.aTq);
                this.rz.setGravity(this.hIL);
                this.ebi = this.mView.findViewById(d.g.divider_line);
                if (this.hIN) {
                    this.ebi.setVisibility(0);
                } else {
                    this.ebi.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.rz != null) {
                this.rz.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
