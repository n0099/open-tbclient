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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes9.dex */
public class VideoPlayInputContainer extends LinearLayout implements m {
    private EditorTools Fv;
    private int Fw;
    private int MH;
    private boolean dtS;
    private boolean dtT;
    private boolean dtU;
    private int dtV;
    private LinearLayout duA;
    private EditText duw;
    private ImageView gpb;
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
        this.dtS = false;
        this.dtT = true;
        this.dtU = true;
        this.dtV = -1;
        this.MH = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.duA = new LinearLayout(getContext());
        this.duA.setOrientation(0);
        this.duA.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.duA, new LinearLayout.LayoutParams(-1, -2));
        fG(context);
        dV(context);
        dU(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fG(Context context) {
        this.gpb = new ImageView(context);
        this.gpb.setEnabled(true);
        this.gpb.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.gpb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.duA.addView(this.gpb, layoutParams);
    }

    private void dV(Context context) {
        this.duw = new EditText(context);
        this.duw.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.duw.setMaxLines(4);
        this.duw.setGravity(16);
        this.duw.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.duw.setBackgroundResource(R.color.common_color_10022);
        e(this.duw, R.drawable.edittext_cursor);
        this.duw.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.duw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.duw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.dtU) {
                    VideoPlayInputContainer.this.dtU = true;
                    if (VideoPlayInputContainer.this.dtV != -1) {
                        VideoPlayInputContainer.this.duw.setSelection(VideoPlayInputContainer.this.dtV);
                        VideoPlayInputContainer.this.dtV = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.duw.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cRN();
            }
        });
        this.duw.setHint(context.getString(R.string.reply_something));
        this.duw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.duw.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.duA.addView(this.duw, layoutParams);
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

    private void dU(Context context) {
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
        this.duA.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.duw.getSelectionStart() > 0) {
                        String substring = this.duw.getText().toString().substring(0, this.duw.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fYs.matcher(substring);
                        if (matcher.find()) {
                            this.duw.getText().delete(this.duw.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.duw.getSelectionStart());
                            return;
                        }
                        this.duw.getText().delete(this.duw.getSelectionStart() - 1, this.duw.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.duw.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.duw.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.duw.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.duw.setSelection(VideoPlayInputContainer.this.duw.getText().length());
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
                        this.duw.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cRN();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.aHc() == EmotionGroupType.NET_SUG) {
                            a(pVar);
                            return;
                        } else {
                            b(pVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.duw.getText().toString();
            if (this.dtT && com.baidu.tieba.face.a.Ab(obj) >= 10 && getContext() != null) {
                e.aDz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.duw);
            }
        }
    }

    private void b(p pVar) {
        if (!this.dtS || pVar.aHc() == EmotionGroupType.LOCAL) {
            String obj = this.duw.getText().toString();
            if (this.dtT && com.baidu.tieba.face.a.Ab(obj) >= 10 && getContext() != null) {
                e.aDz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.duw);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fw;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.duw != null) {
            this.duw.setFocusable(true);
            this.duw.setFocusableInTouchMode(true);
            this.duw.requestFocus();
            l.showSoftKeyPad(getContext(), this.duw);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.MH = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.duw, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.duw, R.drawable.edittext_cursor);
            this.duw.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.duw, R.drawable.edittext_cursor_1);
            this.duw.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        cRN();
        am.setImageResource(this.gpb, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRN() {
        if (this.mSendView.isEnabled()) {
            am.setViewTextColor(this.mSendView, R.color.cp_link_tip_a, 1, this.MH);
        } else {
            am.setViewTextColor(this.mSendView, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.duw;
    }
}
