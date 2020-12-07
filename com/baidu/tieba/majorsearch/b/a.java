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
    private String ejE;
    private SearchMajorActivity lbk;
    private com.baidu.tieba.majorsearch.a lbw;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.lbk = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.lbk).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.lbk.setContentView(this.mRootView);
        this.lbw = new com.baidu.tieba.majorsearch.a(this.mRootView, this.lbk);
        dgT();
        dgG();
        this.ejE = "";
        dgU();
    }

    public void dgT() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lbk.getPageContext().getPageActivity(), view);
                } else {
                    a.this.dgU();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.dgU();
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
                    a.this.ejE = editable.toString();
                    a.this.dgU();
                    a.this.lbw.oJ(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.lbw.a(onFocusChangeListener);
        this.lbw.a(onEditorActionListener);
        this.lbw.d(textWatcher);
    }

    private void dgG() {
        a.InterfaceC0809a interfaceC0809a = new a.InterfaceC0809a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0809a
            public void OJ(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.lbk.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.lbk.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.lbw.a(interfaceC0809a);
        this.lbw.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgU() {
        if (this.lbk != null) {
            if (j.isNetWorkAvailable()) {
                if (this.ejE != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.ejE.trim());
                    this.lbk.sendMessage(httpMessage);
                }
            } else if (this.lbw != null) {
                d(new ErrorData());
                this.lbk.getRefreshView().sD(R.drawable.new_pic_emotion_05);
                this.lbk.showNetRefreshViewNoClick(this.lbw.dgQ(), null);
                this.lbk.getRefreshView().Ek(this.lbk.getString(R.string.im_error_default));
            }
        }
    }

    public void eS(List<String> list) {
        if (this.lbw != null) {
            this.lbw.q(list, this.ejE);
        }
    }

    public void d(ErrorData errorData) {
        if (this.lbw != null) {
            this.lbw.c(errorData);
        }
    }

    public void onResume() {
        if (this.lbw != null) {
            this.lbw.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.lbw.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a dgV() {
        return this.lbw;
    }
}
