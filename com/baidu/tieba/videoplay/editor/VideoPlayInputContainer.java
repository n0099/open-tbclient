package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes11.dex */
public class VideoPlayInputContainer extends LinearLayout implements m {
    private EditorTools FO;
    private int FP;
    private int Ni;
    private EditText dyQ;
    private LinearLayout dyU;
    private boolean dym;
    private boolean dyn;
    private boolean dyo;
    private int dyp;
    private ImageView grr;
    private View mBottomLine;
    private TextView mSendView;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dym = false;
        this.dyn = true;
        this.dyo = true;
        this.dyp = -1;
        this.Ni = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.dyU = new LinearLayout(getContext());
        this.dyU.setOrientation(0);
        this.dyU.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dyU, new LinearLayout.LayoutParams(-1, -2));
        fF(context);
        dZ(context);
        dY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fF(Context context) {
        this.grr = new ImageView(context);
        this.grr.setEnabled(true);
        this.grr.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.grr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.dyU.addView(this.grr, layoutParams);
    }

    private void dZ(Context context) {
        this.dyQ = new EditText(context);
        this.dyQ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyQ.setMaxLines(4);
        this.dyQ.setGravity(16);
        this.dyQ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyQ.setBackgroundResource(R.color.common_color_10022);
        e(this.dyQ, R.drawable.edittext_cursor);
        this.dyQ.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dyQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dyQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.dyo) {
                    VideoPlayInputContainer.this.dyo = true;
                    if (VideoPlayInputContainer.this.dyp != -1) {
                        VideoPlayInputContainer.this.dyQ.setSelection(VideoPlayInputContainer.this.dyp);
                        VideoPlayInputContainer.this.dyp = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.dyQ.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cTn();
            }
        });
        this.dyQ.setHint(context.getString(R.string.reply_something));
        this.dyQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.dyQ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.dyU.addView(this.dyQ, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void dY(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.mSendView.setText(R.string.send_replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.dyU.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dyQ.getSelectionStart() > 0) {
                        String substring = this.dyQ.getText().toString().substring(0, this.dyQ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gaH.matcher(substring);
                        if (matcher.find()) {
                            this.dyQ.getText().delete(this.dyQ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dyQ.getSelectionStart());
                            return;
                        }
                        this.dyQ.getText().delete(this.dyQ.getSelectionStart() - 1, this.dyQ.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.dyQ.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dyQ.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.dyQ.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.dyQ.setSelection(VideoPlayInputContainer.this.dyQ.getText().length());
                                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    VideoPlayInputContainer.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.dyQ.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cTn();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof q)) {
                        q qVar = (q) aVar.data;
                        if (qVar.aJx() == EmotionGroupType.NET_SUG) {
                            a(qVar);
                            return;
                        } else {
                            b(qVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dyQ.getText().toString();
            if (this.dyn && com.baidu.tieba.face.a.As(obj) >= 10 && getContext() != null) {
                e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dyQ);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dym || qVar.aJx() == EmotionGroupType.LOCAL) {
            String obj = this.dyQ.getText().toString();
            if (this.dyn && com.baidu.tieba.face.a.As(obj) >= 10 && getContext() != null) {
                e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dyQ);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dyQ != null) {
            this.dyQ.setFocusable(true);
            this.dyQ.setFocusableInTouchMode(true);
            this.dyQ.requestFocus();
            l.showSoftKeyPad(getContext(), this.dyQ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.Ni = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dyQ, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dyQ, R.drawable.edittext_cursor);
            this.dyQ.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.dyQ, R.drawable.edittext_cursor_1);
            this.dyQ.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        cTn();
        am.setImageResource(this.grr, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTn() {
        if (this.mSendView.isEnabled()) {
            am.setViewTextColor(this.mSendView, R.color.cp_link_tip_a, 1, this.Ni);
        } else {
            am.setViewTextColor(this.mSendView, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.dyQ;
    }
}
