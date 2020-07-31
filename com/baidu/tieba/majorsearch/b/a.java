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
/* loaded from: classes18.dex */
public class a {
    private String drQ;
    private SearchMajorActivity jHW;
    private com.baidu.tieba.majorsearch.a jIi;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.jHW = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.jHW).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.jHW.setContentView(this.mRootView);
        this.jIi = new com.baidu.tieba.majorsearch.a(this.mRootView, this.jHW);
        cEt();
        cEg();
        this.drQ = "";
        cEu();
    }

    public void cEt() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jHW.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cEu();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cEu();
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
                    a.this.drQ = editable.toString();
                    a.this.cEu();
                    a.this.jIi.mu(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.jIi.a(onFocusChangeListener);
        this.jIi.a(onEditorActionListener);
        this.jIi.d(textWatcher);
    }

    private void cEg() {
        a.InterfaceC0695a interfaceC0695a = new a.InterfaceC0695a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0695a
            public void Jh(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.jHW.ab(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.jHW.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.jIi.a(interfaceC0695a);
        this.jIi.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEu() {
        if (this.jHW != null) {
            if (j.isNetWorkAvailable()) {
                if (this.drQ != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.drQ.trim());
                    this.jHW.sendMessage(httpMessage);
                }
            } else if (this.jIi != null) {
                d(new ErrorData());
                this.jHW.getRefreshView().oj(R.drawable.new_pic_emotion_05);
                this.jHW.showNetRefreshViewNoClick(this.jIi.cEq(), null);
                this.jHW.getRefreshView().zX(this.jHW.getString(R.string.im_error_default));
            }
        }
    }

    public void dX(List<String> list) {
        if (this.jIi != null) {
            this.jIi.l(list, this.drQ);
        }
    }

    public void d(ErrorData errorData) {
        if (this.jIi != null) {
            this.jIi.c(errorData);
        }
    }

    public void onResume() {
        if (this.jIi != null) {
            this.jIi.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.jIi.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cEv() {
        return this.jIi;
    }
}
