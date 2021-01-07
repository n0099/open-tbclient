package com.baidu.tieba.majorsearch.a;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private String esI;
    private SearchMajorActivity lgQ;
    private com.baidu.tieba.majorsearch.a lhc;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.lgQ = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.lgQ).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.lgQ.setContentView(this.mRootView);
        this.lhc = new com.baidu.tieba.majorsearch.a(this.mRootView, this.lgQ);
        dgH();
        dgu();
        this.esI = "";
        dgI();
    }

    public void dgH() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.a.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lgQ.getPageContext().getPageActivity(), view);
                } else {
                    a.this.dgI();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.a.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.dgI();
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.majorsearch.a.a.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    a.this.esI = editable.toString();
                    a.this.dgI();
                    a.this.lhc.pi(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.lhc.a(onFocusChangeListener);
        this.lhc.a(onEditorActionListener);
        this.lhc.d(textWatcher);
    }

    private void dgu() {
        SearchMajorResultItemAdapter.a aVar = new SearchMajorResultItemAdapter.a() { // from class: com.baidu.tieba.majorsearch.a.a.4
            @Override // com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter.a
            public void Oq(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.lgQ.Z(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.a.a.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.lgQ.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.lhc.a(aVar);
        this.lhc.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgI() {
        if (this.lgQ != null) {
            if (j.isNetWorkAvailable()) {
                if (this.esI != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.esI.trim());
                    this.lgQ.sendMessage(httpMessage);
                }
            } else if (this.lhc != null) {
                d(new ErrorData());
                this.lgQ.getRefreshView().sP(R.drawable.new_pic_emotion_05);
                this.lgQ.showNetRefreshViewNoClick(this.lhc.dgE(), null);
                this.lgQ.getRefreshView().Eg(this.lgQ.getString(R.string.im_error_default));
            }
        }
    }

    public void eS(List<String> list) {
        if (this.lhc != null) {
            this.lhc.q(list, this.esI);
        }
    }

    public void d(ErrorData errorData) {
        if (this.lhc != null) {
            this.lhc.c(errorData);
        }
    }

    public void onResume() {
        if (this.lhc != null) {
            this.lhc.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.lhc.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a dgJ() {
        return this.lhc;
    }
}
