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
public class b {
    private TextView Sg;
    private List<a> abG;
    private Context haF;
    private LinearLayout haG;
    private View haH;
    private c haK;
    private String titleText;
    private View view;
    private int haI = d.C0095d.cp_bg_line_d;
    private int titleColor = d.C0095d.cp_cont_d;
    private int haJ = d.C0095d.cp_bg_line_a;

    /* renamed from: com.baidu.tieba.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0155b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void iF(int i);
    }

    public b(Context context) {
        if (context != null) {
            this.haF = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.haG = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.Sg = (TextView) this.view.findViewById(d.g.title);
            this.haH = this.view.findViewById(d.g.title_divide_line);
            this.abG = new ArrayList();
        }
    }

    public Context getContext() {
        return this.haF;
    }

    public ViewGroup WP() {
        return this.haG;
    }

    public int bEH() {
        return this.haJ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.haK = cVar;
    }

    public c bEI() {
        return this.haK;
    }

    public void dT(List<a> list) {
        if (list != null) {
            this.abG = list;
            this.haG.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.haG.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onChangeSkinType() {
        aj.k(this.Sg, this.haI);
        aj.i(this.Sg, this.titleColor);
        aj.k(this.haH, this.haJ);
        if (this.abG != null) {
            for (a aVar : this.abG) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bEJ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.Sg.setText(this.titleText);
        } else {
            this.Sg.setVisibility(8);
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private TextView abW;
        private String aff;
        private View dpa;
        private b haL;
        private int haM;
        private int haN;
        private InterfaceC0155b haO;
        private boolean haP;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private View mView;

        public a(b bVar) {
            this(null, bVar);
        }

        public a(String str, b bVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.haM = d.f.person_more_pop_item_bg_selector;
            this.haN = 17;
            this.haP = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.haO != null) {
                        a.this.haO.onClick();
                    }
                    if (a.this.haL != null && a.this.haL.bEI() != null) {
                        a.this.haL.bEI().iF(a.this.mId);
                    }
                }
            };
            this.aff = str;
            this.haL = bVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, b bVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.haM = d.f.person_more_pop_item_bg_selector;
            this.haN = 17;
            this.haP = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.haO != null) {
                        a.this.haO.onClick();
                    }
                    if (a.this.haL != null && a.this.haL.bEI() != null) {
                        a.this.haL.bEI().iF(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aff = str;
            this.haL = bVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aff = str;
            this.abW.setText(this.aff);
        }

        public void a(InterfaceC0155b interfaceC0155b) {
            this.haO = interfaceC0155b;
            initListener();
        }

        public void onChangeSkinType() {
            aj.j(this.abW, this.haM);
            aj.i(this.abW, this.mTextColor);
            aj.k(this.dpa, this.haL.bEH());
        }

        private void initView() {
            if (this.haL != null && this.haL.getContext() != null) {
                this.mView = LayoutInflater.from(this.haL.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.haL.WP(), false);
                this.abW = (TextView) this.mView.findViewById(d.g.item_view);
                this.abW.setText(this.aff);
                this.abW.setGravity(this.haN);
                this.dpa = this.mView.findViewById(d.g.divider_line);
                if (this.haP) {
                    this.dpa.setVisibility(0);
                } else {
                    this.dpa.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.abW != null) {
                this.abW.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
