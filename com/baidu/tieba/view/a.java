package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView abq;
    private Context hjs;
    private LinearLayout hjt;
    private View hju;
    private TextView hjv;
    private d hjw;
    private b hjx;
    private List<C0249a> mItems;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void onItemClick(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hjs = context;
            this.view = LayoutInflater.from(context).inflate(d.i.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hjt = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.abq = (TextView) this.view.findViewById(d.g.title);
            this.hju = this.view.findViewById(d.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hjv = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hjs;
    }

    public ViewGroup adg() {
        return this.hjt;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hjw = dVar;
    }

    public d bFe() {
        return this.hjw;
    }

    public void dN(List<C0249a> list) {
        if (list != null) {
            this.mItems = list;
            this.hjt.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0249a c0249a = list.get(i2);
                    if (c0249a != null) {
                        this.hjt.addView(c0249a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hjx = bVar;
    }

    public void onChangeSkinType() {
        al.j(this.abq, d.C0141d.cp_bg_line_d);
        al.h(this.abq, d.C0141d.cp_cont_j);
        al.j(this.hju, d.C0141d.cp_bg_line_c);
        al.i(this.hjv, d.f.bg_bottom_up_list_dialog_item);
        al.h(this.hjv, d.C0141d.cp_cont_f);
        if (this.mItems != null) {
            for (C0249a c0249a : this.mItems) {
                c0249a.onChangeSkinType();
            }
        }
    }

    public View bFf() {
        if (!StringUtils.isNull(this.titleText)) {
            this.abq.setText(this.titleText);
        } else {
            this.abq.setVisibility(8);
        }
        if (this.hjx != null) {
            this.hjv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hjx.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0249a {
        private String aon;
        private View dNV;
        private int hjA;
        private int hjB;
        private c hjC;
        private boolean hjD;
        private a hjz;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0249a(a aVar) {
            this(null, aVar);
        }

        public C0249a(String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hjA = d.f.person_more_pop_item_bg_selector;
            this.hjB = 17;
            this.hjD = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0249a.this.hjC != null) {
                        C0249a.this.hjC.onClick();
                    }
                    if (C0249a.this.hjz != null && C0249a.this.hjz.bFe() != null) {
                        C0249a.this.hjz.bFe().onItemClick(C0249a.this.mId);
                    }
                }
            };
            this.aon = str;
            this.hjz = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0249a(int i, String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hjA = d.f.person_more_pop_item_bg_selector;
            this.hjB = 17;
            this.hjD = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0249a.this.hjC != null) {
                        C0249a.this.hjC.onClick();
                    }
                    if (C0249a.this.hjz != null && C0249a.this.hjz.bFe() != null) {
                        C0249a.this.hjz.bFe().onItemClick(C0249a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aon = str;
            this.hjz = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aon = str;
            this.mTextView.setText(this.aon);
        }

        public void a(c cVar) {
            this.hjC = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, d.C0141d.cp_cont_b);
            al.j(this.dNV, d.C0141d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hjz != null && this.hjz.getContext() != null) {
                this.mView = LayoutInflater.from(this.hjz.getContext()).inflate(d.i.bottom_up_list_dialog_item, this.hjz.adg(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.aon);
                this.mTextView.setGravity(this.hjB);
                this.dNV = this.mView.findViewById(d.g.divider_line);
                if (this.hjD) {
                    this.dNV.setVisibility(0);
                } else {
                    this.dNV.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.mTextView != null) {
                this.mTextView.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
