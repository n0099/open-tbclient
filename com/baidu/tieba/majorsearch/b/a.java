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
    private String dBR;
    private com.baidu.tieba.majorsearch.a jXB;
    private SearchMajorActivity jXp;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.jXp = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.jXp).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.jXp.setContentView(this.mRootView);
        this.jXB = new com.baidu.tieba.majorsearch.a(this.mRootView, this.jXp);
        cPk();
        cOX();
        this.dBR = "";
        cPl();
    }

    public void cPk() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jXp.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cPl();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cPl();
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
                    a.this.dBR = editable.toString();
                    a.this.cPl();
                    a.this.jXB.mX(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.jXB.a(onFocusChangeListener);
        this.jXB.a(onEditorActionListener);
        this.jXB.d(textWatcher);
    }

    private void cOX() {
        a.InterfaceC0746a interfaceC0746a = new a.InterfaceC0746a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0746a
            public void LZ(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.jXp.ad(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.jXp.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.jXB.a(interfaceC0746a);
        this.jXB.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPl() {
        if (this.jXp != null) {
            if (j.isNetWorkAvailable()) {
                if (this.dBR != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.dBR.trim());
                    this.jXp.sendMessage(httpMessage);
                }
            } else if (this.jXB != null) {
                d(new ErrorData());
                this.jXp.getRefreshView().qu(R.drawable.new_pic_emotion_05);
                this.jXp.showNetRefreshViewNoClick(this.jXB.cPh(), null);
                this.jXp.getRefreshView().Cn(this.jXp.getString(R.string.im_error_default));
            }
        }
    }

    public void ef(List<String> list) {
        if (this.jXB != null) {
            this.jXB.l(list, this.dBR);
        }
    }

    public void d(ErrorData errorData) {
        if (this.jXB != null) {
            this.jXB.c(errorData);
        }
    }

    public void onResume() {
        if (this.jXB != null) {
            this.jXB.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.jXB.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cPm() {
        return this.jXB;
    }
}
