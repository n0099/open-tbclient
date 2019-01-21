package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView anq;
    private Context hQZ;
    private LinearLayout hRa;
    private View hRb;
    private TextView hRc;
    private d hRd;
    private b hRe;
    private List<C0333a> mItems;
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
        void hR(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hQZ = context;
            this.view = LayoutInflater.from(context).inflate(e.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hRa = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.anq = (TextView) this.view.findViewById(e.g.title);
            this.hRb = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hRc = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hQZ;
    }

    public ViewGroup akV() {
        return this.hRa;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hRd = dVar;
    }

    public d bNv() {
        return this.hRd;
    }

    public void ef(List<C0333a> list) {
        if (list != null) {
            this.mItems = list;
            this.hRa.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0333a c0333a = list.get(i2);
                    if (c0333a != null) {
                        this.hRa.addView(c0333a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hRe = bVar;
    }

    public void onChangeSkinType() {
        al.j(this.anq, e.d.cp_bg_line_d);
        al.h(this.anq, e.d.cp_cont_j);
        al.j(this.hRb, e.d.cp_bg_line_c);
        al.i(this.hRc, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hRc, e.d.cp_cont_f);
        if (this.mItems != null) {
            for (C0333a c0333a : this.mItems) {
                c0333a.onChangeSkinType();
            }
        }
    }

    public View bNw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.anq.setText(this.titleText);
        } else {
            this.anq.setVisibility(8);
        }
        if (this.hRe != null) {
            this.hRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hRe.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0333a {
        private View euU;
        private a hRg;
        private int hRh;
        private int hRi;
        private c hRj;
        private boolean hRk;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0333a(a aVar) {
            this(null, aVar);
        }

        public C0333a(String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hRh = e.f.person_more_pop_item_bg_selector;
            this.hRi = 17;
            this.hRk = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0333a.this.hRj != null) {
                        C0333a.this.hRj.onClick();
                    }
                    if (C0333a.this.hRg != null && C0333a.this.hRg.bNv() != null) {
                        C0333a.this.hRg.bNv().hR(C0333a.this.mId);
                    }
                }
            };
            this.mText = str;
            this.hRg = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0333a(int i, String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hRh = e.f.person_more_pop_item_bg_selector;
            this.hRi = 17;
            this.hRk = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0333a.this.hRj != null) {
                        C0333a.this.hRj.onClick();
                    }
                    if (C0333a.this.hRg != null && C0333a.this.hRg.bNv() != null) {
                        C0333a.this.hRg.bNv().hR(C0333a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.mText = str;
            this.hRg = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.mText = str;
            this.mTextView.setText(this.mText);
        }

        public void a(c cVar) {
            this.hRj = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_b);
            al.j(this.euU, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hRg != null && this.hRg.getContext() != null) {
                this.mView = LayoutInflater.from(this.hRg.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hRg.akV(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hRi);
                this.euU = this.mView.findViewById(e.g.divider_line);
                if (this.hRk) {
                    this.euU.setVisibility(0);
                } else {
                    this.euU.setVisibility(8);
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
