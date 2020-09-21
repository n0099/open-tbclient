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
/* loaded from: classes23.dex */
public class a {
    private String dDW;
    private SearchMajorActivity kfZ;
    private com.baidu.tieba.majorsearch.a kgl;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.kfZ = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.kfZ).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.kfZ.setContentView(this.mRootView);
        this.kgl = new com.baidu.tieba.majorsearch.a(this.mRootView, this.kfZ);
        cSQ();
        cSD();
        this.dDW = "";
        cSR();
    }

    public void cSQ() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kfZ.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cSR();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cSR();
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
                    a.this.dDW = editable.toString();
                    a.this.cSR();
                    a.this.kgl.nf(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.kgl.a(onFocusChangeListener);
        this.kgl.a(onEditorActionListener);
        this.kgl.d(textWatcher);
    }

    private void cSD() {
        a.InterfaceC0743a interfaceC0743a = new a.InterfaceC0743a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0743a
            public void MC(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.kfZ.ac(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.kfZ.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.kgl.a(interfaceC0743a);
        this.kgl.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSR() {
        if (this.kfZ != null) {
            if (j.isNetWorkAvailable()) {
                if (this.dDW != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.dDW.trim());
                    this.kfZ.sendMessage(httpMessage);
                }
            } else if (this.kgl != null) {
                d(new ErrorData());
                this.kfZ.getRefreshView().qL(R.drawable.new_pic_emotion_05);
                this.kfZ.showNetRefreshViewNoClick(this.kgl.cSN(), null);
                this.kfZ.getRefreshView().CK(this.kfZ.getString(R.string.im_error_default));
            }
        }
    }

    public void en(List<String> list) {
        if (this.kgl != null) {
            this.kgl.m(list, this.dDW);
        }
    }

    public void d(ErrorData errorData) {
        if (this.kgl != null) {
            this.kgl.c(errorData);
        }
    }

    public void onResume() {
        if (this.kgl != null) {
            this.kgl.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.kgl.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cSS() {
        return this.kgl;
    }
}
