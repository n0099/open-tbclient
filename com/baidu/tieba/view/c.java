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
    private TextView aIe;
    private List<a> aRz;
    private Context hAj;
    private LinearLayout hAk;
    private View hAl;
    private TextView hAm;
    private d hAn;
    private b hAo;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* renamed from: com.baidu.tieba.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0250c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void lC(int i);
    }

    public c(Context context) {
        if (context != null) {
            this.hAj = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hAk = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aIe = (TextView) this.view.findViewById(d.g.title);
            this.hAl = this.view.findViewById(d.g.title_divide_line);
            this.aRz = new ArrayList();
            this.hAm = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hAj;
    }

    public ViewGroup aft() {
        return this.hAk;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hAn = dVar;
    }

    public d bEK() {
        return this.hAn;
    }

    public void dO(List<a> list) {
        if (list != null) {
            this.aRz = list;
            this.hAk.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hAk.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hAo = bVar;
    }

    public void onChangeSkinType() {
        aj.t(this.aIe, d.C0140d.cp_bg_line_d);
        aj.r(this.aIe, d.C0140d.cp_cont_j);
        aj.t(this.hAl, d.C0140d.cp_bg_line_c);
        aj.s(this.hAm, d.f.bg_bottom_up_list_dialog_item);
        aj.r(this.hAm, d.C0140d.cp_cont_f);
        if (this.aRz != null) {
            for (a aVar : this.aRz) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bEL() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aIe.setText(this.titleText);
        } else {
            this.aIe.setVisibility(8);
        }
        if (this.hAo != null) {
            this.hAm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hAo.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aUX;
        private View egZ;
        private c hAq;
        private int hAr;
        private int hAs;
        private InterfaceC0250c hAt;
        private boolean hAu;
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
            this.hAr = d.f.person_more_pop_item_bg_selector;
            this.hAs = 17;
            this.hAu = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hAt != null) {
                        a.this.hAt.onClick();
                    }
                    if (a.this.hAq != null && a.this.hAq.bEK() != null) {
                        a.this.hAq.bEK().lC(a.this.mId);
                    }
                }
            };
            this.aUX = str;
            this.hAq = cVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hAr = d.f.person_more_pop_item_bg_selector;
            this.hAs = 17;
            this.hAu = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hAt != null) {
                        a.this.hAt.onClick();
                    }
                    if (a.this.hAq != null && a.this.hAq.bEK() != null) {
                        a.this.hAq.bEK().lC(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aUX = str;
            this.hAq = cVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aUX = str;
            this.rz.setText(this.aUX);
        }

        public void a(InterfaceC0250c interfaceC0250c) {
            this.hAt = interfaceC0250c;
            initListener();
        }

        public void onChangeSkinType() {
            aj.s(this.rz, d.f.bg_bottom_up_list_dialog_item);
            aj.r(this.rz, d.C0140d.cp_cont_b);
            aj.t(this.egZ, d.C0140d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hAq != null && this.hAq.getContext() != null) {
                this.mView = LayoutInflater.from(this.hAq.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hAq.aft(), false);
                this.rz = (TextView) this.mView.findViewById(d.g.item_view);
                this.rz.setText(this.aUX);
                this.rz.setGravity(this.hAs);
                this.egZ = this.mView.findViewById(d.g.divider_line);
                if (this.hAu) {
                    this.egZ.setVisibility(0);
                } else {
                    this.egZ.setVisibility(8);
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
