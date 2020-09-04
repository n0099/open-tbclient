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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes18.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools aaA;
    private int aaB;
    private int aiD;
    private TextView buE;
    private EditText eMK;
    private LinearLayout eMO;
    private boolean eMg;
    private boolean eMh;
    private boolean eMi;
    private int eMj;
    private ImageView hWv;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMg = false;
        this.eMh = true;
        this.eMi = true;
        this.eMj = -1;
        this.aiD = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.eMO = new LinearLayout(getContext());
        this.eMO.setOrientation(0);
        this.eMO.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.eMO, new LinearLayout.LayoutParams(-1, -2));
        fL(context);
        eg(context);
        ef(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fL(Context context) {
        this.hWv = new ImageView(context);
        this.hWv.setEnabled(true);
        this.hWv.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.hWv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.eMO.addView(this.hWv, layoutParams);
    }

    private void eg(Context context) {
        this.eMK = new EditText(context);
        this.eMK.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMK.setMaxLines(4);
        this.eMK.setGravity(16);
        this.eMK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMK.setBackgroundResource(R.color.common_color_10022);
        e(this.eMK, R.drawable.edittext_cursor);
        this.eMK.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.eMK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eMK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.eMi) {
                    VideoPlayInputContainer.this.eMi = true;
                    if (VideoPlayInputContainer.this.eMj != -1) {
                        VideoPlayInputContainer.this.eMK.setSelection(VideoPlayInputContainer.this.eMj);
                        VideoPlayInputContainer.this.eMj = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.eMK.getText().toString()));
                }
                VideoPlayInputContainer.this.buE.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dEZ();
            }
        });
        this.eMK.setHint(context.getString(R.string.reply_something));
        this.eMK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.eMK.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.eMO.addView(this.eMK, layoutParams);
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

    private void ef(Context context) {
        this.buE = new TextView(context);
        this.buE.setGravity(17);
        this.buE.setIncludeFontPadding(false);
        this.buE.setEnabled(false);
        this.buE.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.buE.setText(R.string.send_replay);
        this.buE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.eMO.addView(this.buE, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eMK.getSelectionStart() > 0) {
                        String substring = this.eMK.getText().toString().substring(0, this.eMK.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hEV.matcher(substring);
                        if (matcher.find()) {
                            this.eMK.getText().delete(this.eMK.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eMK.getSelectionStart());
                            return;
                        }
                        this.eMK.getText().delete(this.eMK.getSelectionStart() - 1, this.eMK.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.eMK.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eMK.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.eMK.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.eMK.setSelection(VideoPlayInputContainer.this.eMK.getText().length());
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
                        this.eMK.setText((CharSequence) null);
                    }
                    this.buE.setEnabled(false);
                    dEZ();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof t)) {
                        t tVar = (t) aVar.data;
                        if (tVar.bmP() == EmotionGroupType.NET_SUG) {
                            a(tVar);
                            return;
                        } else {
                            b(tVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(t tVar) {
        if (tVar != null && !TextUtils.isEmpty(tVar.getName()) && !TextUtils.isEmpty(tVar.getUrl())) {
            String obj = this.eMK.getText().toString();
            if (this.eMh && com.baidu.tieba.face.a.HE(obj) >= 10 && getContext() != null) {
                e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), tVar, this.eMK);
            }
        }
    }

    private void b(t tVar) {
        if (!this.eMg || tVar.bmP() == EmotionGroupType.LOCAL) {
            String obj = this.eMK.getText().toString();
            if (this.eMh && com.baidu.tieba.face.a.HE(obj) >= 10 && getContext() != null) {
                e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), tVar, this.eMK);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaB = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaB;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.eMK != null) {
            this.eMK.setFocusable(true);
            this.eMK.setFocusableInTouchMode(true);
            this.eMK.requestFocus();
            l.showSoftKeyPad(getContext(), this.eMK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.aiD = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.eMK, R.color.cp_cont_f, 2, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.eMK, R.drawable.edittext_cursor);
            this.eMK.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.eMK, R.drawable.edittext_cursor_1);
            this.eMK.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        dEZ();
        ap.setImageResource(this.hWv, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEZ() {
        if (this.buE.isEnabled()) {
            ap.setViewTextColor(this.buE, R.color.cp_link_tip_a, 1, this.aiD);
        } else {
            ap.setViewTextColor(this.buE, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.eMK;
    }
}
