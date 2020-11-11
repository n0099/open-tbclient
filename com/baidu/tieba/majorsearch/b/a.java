package com.baidu.tieba.majorsearch.b;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.a.a;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private String eel;
    private SearchMajorActivity kNF;
    private com.baidu.tieba.majorsearch.a kNR;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.kNF = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.kNF).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.kNF.setContentView(this.mRootView);
        this.kNR = new com.baidu.tieba.majorsearch.a(this.mRootView, this.kNF);
        dck();
        dbX();
        this.eel = "";
        dcl();
    }

    public void dck() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kNF.getPageContext().getPageActivity(), view);
                } else {
                    a.this.dcl();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.dcl();
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.majorsearch.b.a.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    a.this.eel = editable.toString();
                    a.this.dcl();
                    a.this.kNR.ol(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.kNR.a(onFocusChangeListener);
        this.kNR.a(onEditorActionListener);
        this.kNR.d(textWatcher);
    }

    private void dbX() {
        a.InterfaceC0791a interfaceC0791a = new a.InterfaceC0791a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0791a
            public void Og(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.kNF.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.kNF.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.kNR.a(interfaceC0791a);
        this.kNR.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcl() {
        if (this.kNF != null) {
            if (j.isNetWorkAvailable()) {
                if (this.eel != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.eel.trim());
                    this.kNF.sendMessage(httpMessage);
                }
            } else if (this.kNR != null) {
                d(new ErrorData());
                this.kNF.getRefreshView().rE(R.drawable.new_pic_emotion_05);
                this.kNF.showNetRefreshViewNoClick(this.kNR.dch(), null);
                this.kNF.getRefreshView().Ed(this.kNF.getString(R.string.im_error_default));
            }
        }
    }

    public void eH(List<String> list) {
        if (this.kNR != null) {
            this.kNR.p(list, this.eel);
        }
    }

    public void d(ErrorData errorData) {
        if (this.kNR != null) {
            this.kNR.c(errorData);
        }
    }

    public void onResume() {
        if (this.kNR != null) {
            this.kNR.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.kNR.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a dcm() {
        return this.kNR;
    }
}
