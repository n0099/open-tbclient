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
/* loaded from: classes11.dex */
public class a {
    private String dhj;
    private SearchMajorActivity jik;
    private com.baidu.tieba.majorsearch.a jiw;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.jik = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.jik).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.jik.setContentView(this.mRootView);
        this.jiw = new com.baidu.tieba.majorsearch.a(this.mRootView, this.jik);
        cwE();
        cwr();
        this.dhj = "";
        cwF();
    }

    public void cwE() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jik.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cwF();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cwF();
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
                    a.this.dhj = editable.toString();
                    a.this.cwF();
                    a.this.jiw.lG(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.jiw.a(onFocusChangeListener);
        this.jiw.a(onEditorActionListener);
        this.jiw.d(textWatcher);
    }

    private void cwr() {
        a.InterfaceC0671a interfaceC0671a = new a.InterfaceC0671a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0671a
            public void HQ(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.jik.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.jik.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.jiw.a(interfaceC0671a);
        this.jiw.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwF() {
        if (this.jik != null) {
            if (j.isNetWorkAvailable()) {
                if (this.dhj != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.dhj.trim());
                    this.jik.sendMessage(httpMessage);
                }
            } else if (this.jiw != null) {
                d(new ErrorData());
                this.jik.getRefreshView().nw(R.drawable.new_pic_emotion_05);
                this.jik.showNetRefreshViewNoClick(this.jiw.cwB(), null);
                this.jik.getRefreshView().yx(this.jik.getString(R.string.im_error_default));
            }
        }
    }

    public void dC(List<String> list) {
        if (this.jiw != null) {
            this.jiw.l(list, this.dhj);
        }
    }

    public void d(ErrorData errorData) {
        if (this.jiw != null) {
            this.jiw.c(errorData);
        }
    }

    public void onResume() {
        if (this.jiw != null) {
            this.jiw.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.jiw.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cwG() {
        return this.jiw;
    }
}
