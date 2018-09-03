package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView aaX;
    private List<C0251a> akQ;
    private Context hoG;
    private LinearLayout hoH;
    private View hoI;
    private TextView hoJ;
    private d hoK;
    private b hoL;
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
        void iV(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hoG = context;
            this.view = LayoutInflater.from(context).inflate(f.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hoH = (LinearLayout) this.view.findViewById(f.g.content_view);
            this.aaX = (TextView) this.view.findViewById(f.g.title);
            this.hoI = this.view.findViewById(f.g.title_divide_line);
            this.akQ = new ArrayList();
            this.hoJ = (TextView) this.view.findViewById(f.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hoG;
    }

    public ViewGroup aee() {
        return this.hoH;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hoK = dVar;
    }

    public d bEr() {
        return this.hoK;
    }

    public void dM(List<C0251a> list) {
        if (list != null) {
            this.akQ = list;
            this.hoH.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0251a c0251a = list.get(i2);
                    if (c0251a != null) {
                        this.hoH.addView(c0251a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hoL = bVar;
    }

    public void onChangeSkinType() {
        am.j(this.aaX, f.d.cp_bg_line_d);
        am.h(this.aaX, f.d.cp_cont_j);
        am.j(this.hoI, f.d.cp_bg_line_c);
        am.i(this.hoJ, f.C0146f.bg_bottom_up_list_dialog_item);
        am.h(this.hoJ, f.d.cp_cont_f);
        if (this.akQ != null) {
            for (C0251a c0251a : this.akQ) {
                c0251a.onChangeSkinType();
            }
        }
    }

    public View bEs() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aaX.setText(this.titleText);
        } else {
            this.aaX.setVisibility(8);
        }
        if (this.hoL != null) {
            this.hoJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hoL.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0251a {
        private String aop;
        private View dTU;
        private a hoN;
        private int hoO;
        private int hoP;
        private c hoQ;
        private boolean hoR;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0251a(a aVar) {
            this(null, aVar);
        }

        public C0251a(String str, a aVar) {
            this.mTextColor = f.C0146f.person_more_pop_cancel_text_selector;
            this.hoO = f.C0146f.person_more_pop_item_bg_selector;
            this.hoP = 17;
            this.hoR = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0251a.this.hoQ != null) {
                        C0251a.this.hoQ.onClick();
                    }
                    if (C0251a.this.hoN != null && C0251a.this.hoN.bEr() != null) {
                        C0251a.this.hoN.bEr().iV(C0251a.this.mId);
                    }
                }
            };
            this.aop = str;
            this.hoN = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0251a(int i, String str, a aVar) {
            this.mTextColor = f.C0146f.person_more_pop_cancel_text_selector;
            this.hoO = f.C0146f.person_more_pop_item_bg_selector;
            this.hoP = 17;
            this.hoR = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0251a.this.hoQ != null) {
                        C0251a.this.hoQ.onClick();
                    }
                    if (C0251a.this.hoN != null && C0251a.this.hoN.bEr() != null) {
                        C0251a.this.hoN.bEr().iV(C0251a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aop = str;
            this.hoN = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aop = str;
            this.mTextView.setText(this.aop);
        }

        public void a(c cVar) {
            this.hoQ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.i(this.mTextView, f.C0146f.bg_bottom_up_list_dialog_item);
            am.h(this.mTextView, f.d.cp_cont_b);
            am.j(this.dTU, f.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hoN != null && this.hoN.getContext() != null) {
                this.mView = LayoutInflater.from(this.hoN.getContext()).inflate(f.h.bottom_up_list_dialog_item, this.hoN.aee(), false);
                this.mTextView = (TextView) this.mView.findViewById(f.g.item_view);
                this.mTextView.setText(this.aop);
                this.mTextView.setGravity(this.hoP);
                this.dTU = this.mView.findViewById(f.g.divider_line);
                if (this.hoR) {
                    this.dTU.setVisibility(0);
                } else {
                    this.dTU.setVisibility(8);
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
