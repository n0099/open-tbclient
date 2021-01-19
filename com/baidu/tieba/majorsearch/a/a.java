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
/* loaded from: classes7.dex */
public class a {
    private String enU;
    private SearchMajorActivity lcj;
    private com.baidu.tieba.majorsearch.a lcw;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.lcj = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.lcj).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.lcj.setContentView(this.mRootView);
        this.lcw = new com.baidu.tieba.majorsearch.a(this.mRootView, this.lcj);
        dcP();
        dcC();
        this.enU = "";
        dcQ();
    }

    public void dcP() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.a.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lcj.getPageContext().getPageActivity(), view);
                } else {
                    a.this.dcQ();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.a.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.dcQ();
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
                    a.this.enU = editable.toString();
                    a.this.dcQ();
                    a.this.lcw.pe(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.lcw.a(onFocusChangeListener);
        this.lcw.a(onEditorActionListener);
        this.lcw.d(textWatcher);
    }

    private void dcC() {
        SearchMajorResultItemAdapter.a aVar = new SearchMajorResultItemAdapter.a() { // from class: com.baidu.tieba.majorsearch.a.a.4
            @Override // com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter.a
            public void Nj(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.lcj.Z(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.a.a.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.lcj.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.lcw.a(aVar);
        this.lcw.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcQ() {
        if (this.lcj != null) {
            if (j.isNetWorkAvailable()) {
                if (this.enU != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.enU.trim());
                    this.lcj.sendMessage(httpMessage);
                }
            } else if (this.lcw != null) {
                d(new ErrorData());
                this.lcj.getRefreshView().rj(R.drawable.new_pic_emotion_05);
                this.lcj.showNetRefreshViewNoClick(this.lcw.dcM(), null);
                this.lcj.getRefreshView().CV(this.lcj.getString(R.string.im_error_default));
            }
        }
    }

    public void eS(List<String> list) {
        if (this.lcw != null) {
            this.lcw.q(list, this.enU);
        }
    }

    public void d(ErrorData errorData) {
        if (this.lcw != null) {
            this.lcw.c(errorData);
        }
    }

    public void onResume() {
        if (this.lcw != null) {
            this.lcw.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.lcw.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a dcR() {
        return this.lcw;
    }
}
