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
    private TextView aGL;
    private List<a> aQc;
    private Context hyD;
    private LinearLayout hyE;
    private View hyF;
    private TextView hyG;
    private d hyH;
    private b hyI;
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
        void lG(int i);
    }

    public c(Context context) {
        if (context != null) {
            this.hyD = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hyE = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aGL = (TextView) this.view.findViewById(d.g.title);
            this.hyF = this.view.findViewById(d.g.title_divide_line);
            this.aQc = new ArrayList();
            this.hyG = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hyD;
    }

    public ViewGroup aeo() {
        return this.hyE;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hyH = dVar;
    }

    public d bDU() {
        return this.hyH;
    }

    public void dI(List<a> list) {
        if (list != null) {
            this.aQc = list;
            this.hyE.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hyE.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hyI = bVar;
    }

    public void onChangeSkinType() {
        aj.t(this.aGL, d.C0108d.cp_bg_line_d);
        aj.r(this.aGL, d.C0108d.cp_cont_j);
        aj.t(this.hyF, d.C0108d.cp_bg_line_c);
        aj.s(this.hyG, d.f.bg_bottom_up_list_dialog_item);
        aj.r(this.hyG, d.C0108d.cp_cont_f);
        if (this.aQc != null) {
            for (a aVar : this.aQc) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bDV() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aGL.setText(this.titleText);
        } else {
            this.aGL.setVisibility(8);
        }
        if (this.hyI != null) {
            this.hyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hyI.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aTs;
        private View ecN;
        private c hyK;
        private int hyL;
        private int hyM;
        private InterfaceC0168c hyN;
        private boolean hyO;
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
            this.hyL = d.f.person_more_pop_item_bg_selector;
            this.hyM = 17;
            this.hyO = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hyN != null) {
                        a.this.hyN.onClick();
                    }
                    if (a.this.hyK != null && a.this.hyK.bDU() != null) {
                        a.this.hyK.bDU().lG(a.this.mId);
                    }
                }
            };
            this.aTs = str;
            this.hyK = cVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hyL = d.f.person_more_pop_item_bg_selector;
            this.hyM = 17;
            this.hyO = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hyN != null) {
                        a.this.hyN.onClick();
                    }
                    if (a.this.hyK != null && a.this.hyK.bDU() != null) {
                        a.this.hyK.bDU().lG(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aTs = str;
            this.hyK = cVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aTs = str;
            this.rz.setText(this.aTs);
        }

        public void a(InterfaceC0168c interfaceC0168c) {
            this.hyN = interfaceC0168c;
            initListener();
        }

        public void onChangeSkinType() {
            aj.s(this.rz, d.f.bg_bottom_up_list_dialog_item);
            aj.r(this.rz, d.C0108d.cp_cont_b);
            aj.t(this.ecN, d.C0108d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hyK != null && this.hyK.getContext() != null) {
                this.mView = LayoutInflater.from(this.hyK.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hyK.aeo(), false);
                this.rz = (TextView) this.mView.findViewById(d.g.item_view);
                this.rz.setText(this.aTs);
                this.rz.setGravity(this.hyM);
                this.ecN = this.mView.findViewById(d.g.divider_line);
                if (this.hyO) {
                    this.ecN.setVisibility(0);
                } else {
                    this.ecN.setVisibility(8);
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
