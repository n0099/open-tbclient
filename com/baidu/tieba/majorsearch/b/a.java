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
    private SearchMajorActivity lbm;
    private com.baidu.tieba.majorsearch.a lby;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.lbm = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.lbm).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.lbm.setContentView(this.mRootView);
        this.lby = new com.baidu.tieba.majorsearch.a(this.mRootView, this.lbm);
        dgU();
        dgH();
        this.ejE = "";
        dgV();
    }

    public void dgU() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lbm.getPageContext().getPageActivity(), view);
                } else {
                    a.this.dgV();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.dgV();
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
                    a.this.dgV();
                    a.this.lby.oJ(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.lby.a(onFocusChangeListener);
        this.lby.a(onEditorActionListener);
        this.lby.d(textWatcher);
    }

    private void dgH() {
        a.InterfaceC0809a interfaceC0809a = new a.InterfaceC0809a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0809a
            public void OJ(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.lbm.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.lbm.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.lby.a(interfaceC0809a);
        this.lby.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgV() {
        if (this.lbm != null) {
            if (j.isNetWorkAvailable()) {
                if (this.ejE != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.ejE.trim());
                    this.lbm.sendMessage(httpMessage);
                }
            } else if (this.lby != null) {
                d(new ErrorData());
                this.lbm.getRefreshView().sD(R.drawable.new_pic_emotion_05);
                this.lbm.showNetRefreshViewNoClick(this.lby.dgR(), null);
                this.lbm.getRefreshView().Ek(this.lbm.getString(R.string.im_error_default));
            }
        }
    }

    public void eS(List<String> list) {
        if (this.lby != null) {
            this.lby.q(list, this.ejE);
        }
    }

    public void d(ErrorData errorData) {
        if (this.lby != null) {
            this.lby.c(errorData);
        }
    }

    public void onResume() {
        if (this.lby != null) {
            this.lby.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.lby.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a dgW() {
        return this.lby;
    }
}
