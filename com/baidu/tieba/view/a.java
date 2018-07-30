package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView aaW;
    private List<C0251a> akQ;
    private Context hoF;
    private LinearLayout hoG;
    private View hoH;
    private TextView hoI;
    private d hoJ;
    private b hoK;
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
        void iW(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hoF = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hoG = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aaW = (TextView) this.view.findViewById(d.g.title);
            this.hoH = this.view.findViewById(d.g.title_divide_line);
            this.akQ = new ArrayList();
            this.hoI = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hoF;
    }

    public ViewGroup aec() {
        return this.hoG;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hoJ = dVar;
    }

    public d bEp() {
        return this.hoJ;
    }

    public void dM(List<C0251a> list) {
        if (list != null) {
            this.akQ = list;
            this.hoG.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0251a c0251a = list.get(i2);
                    if (c0251a != null) {
                        this.hoG.addView(c0251a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hoK = bVar;
    }

    public void onChangeSkinType() {
        am.j(this.aaW, d.C0140d.cp_bg_line_d);
        am.h(this.aaW, d.C0140d.cp_cont_j);
        am.j(this.hoH, d.C0140d.cp_bg_line_c);
        am.i(this.hoI, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.hoI, d.C0140d.cp_cont_f);
        if (this.akQ != null) {
            for (C0251a c0251a : this.akQ) {
                c0251a.onChangeSkinType();
            }
        }
    }

    public View bEq() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aaW.setText(this.titleText);
        } else {
            this.aaW.setVisibility(8);
        }
        if (this.hoK != null) {
            this.hoI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hoK.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0251a {
        private String aoo;
        private View dTZ;
        private a hoM;
        private int hoN;
        private int hoO;
        private c hoP;
        private boolean hoQ;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0251a(a aVar) {
            this(null, aVar);
        }

        public C0251a(String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hoN = d.f.person_more_pop_item_bg_selector;
            this.hoO = 17;
            this.hoQ = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0251a.this.hoP != null) {
                        C0251a.this.hoP.onClick();
                    }
                    if (C0251a.this.hoM != null && C0251a.this.hoM.bEp() != null) {
                        C0251a.this.hoM.bEp().iW(C0251a.this.mId);
                    }
                }
            };
            this.aoo = str;
            this.hoM = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0251a(int i, String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hoN = d.f.person_more_pop_item_bg_selector;
            this.hoO = 17;
            this.hoQ = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0251a.this.hoP != null) {
                        C0251a.this.hoP.onClick();
                    }
                    if (C0251a.this.hoM != null && C0251a.this.hoM.bEp() != null) {
                        C0251a.this.hoM.bEp().iW(C0251a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aoo = str;
            this.hoM = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aoo = str;
            this.mTextView.setText(this.aoo);
        }

        public void a(c cVar) {
            this.hoP = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            am.h(this.mTextView, d.C0140d.cp_cont_b);
            am.j(this.dTZ, d.C0140d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hoM != null && this.hoM.getContext() != null) {
                this.mView = LayoutInflater.from(this.hoM.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hoM.aec(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.aoo);
                this.mTextView.setGravity(this.hoO);
                this.dTZ = this.mView.findViewById(d.g.divider_line);
                if (this.hoQ) {
                    this.dTZ.setVisibility(0);
                } else {
                    this.dTZ.setVisibility(8);
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
