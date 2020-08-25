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
    private EditorTools aay;
    private int aaz;
    private int aiB;
    private TextView buB;
    private EditText eMG;
    private LinearLayout eMK;
    private boolean eMc;
    private boolean eMd;
    private boolean eMe;
    private int eMf;
    private ImageView hWp;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMc = false;
        this.eMd = true;
        this.eMe = true;
        this.eMf = -1;
        this.aiB = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.eMK = new LinearLayout(getContext());
        this.eMK.setOrientation(0);
        this.eMK.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.eMK, new LinearLayout.LayoutParams(-1, -2));
        fL(context);
        eg(context);
        ef(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fL(Context context) {
        this.hWp = new ImageView(context);
        this.hWp.setEnabled(true);
        this.hWp.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.hWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.eMK.addView(this.hWp, layoutParams);
    }

    private void eg(Context context) {
        this.eMG = new EditText(context);
        this.eMG.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMG.setMaxLines(4);
        this.eMG.setGravity(16);
        this.eMG.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMG.setBackgroundResource(R.color.common_color_10022);
        e(this.eMG, R.drawable.edittext_cursor);
        this.eMG.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.eMG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eMG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.eMe) {
                    VideoPlayInputContainer.this.eMe = true;
                    if (VideoPlayInputContainer.this.eMf != -1) {
                        VideoPlayInputContainer.this.eMG.setSelection(VideoPlayInputContainer.this.eMf);
                        VideoPlayInputContainer.this.eMf = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.eMG.getText().toString()));
                }
                VideoPlayInputContainer.this.buB.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dEQ();
            }
        });
        this.eMG.setHint(context.getString(R.string.reply_something));
        this.eMG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.eMG.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.eMK.addView(this.eMG, layoutParams);
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
        this.buB = new TextView(context);
        this.buB.setGravity(17);
        this.buB.setIncludeFontPadding(false);
        this.buB.setEnabled(false);
        this.buB.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.buB.setText(R.string.send_replay);
        this.buB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.eMK.addView(this.buB, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eMG.getSelectionStart() > 0) {
                        String substring = this.eMG.getText().toString().substring(0, this.eMG.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hEP.matcher(substring);
                        if (matcher.find()) {
                            this.eMG.getText().delete(this.eMG.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eMG.getSelectionStart());
                            return;
                        }
                        this.eMG.getText().delete(this.eMG.getSelectionStart() - 1, this.eMG.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.eMG.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eMG.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.eMG.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.eMG.setSelection(VideoPlayInputContainer.this.eMG.getText().length());
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
                        this.eMG.setText((CharSequence) null);
                    }
                    this.buB.setEnabled(false);
                    dEQ();
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
            String obj = this.eMG.getText().toString();
            if (this.eMd && com.baidu.tieba.face.a.HD(obj) >= 10 && getContext() != null) {
                e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), tVar, this.eMG);
            }
        }
    }

    private void b(t tVar) {
        if (!this.eMc || tVar.bmP() == EmotionGroupType.LOCAL) {
            String obj = this.eMG.getText().toString();
            if (this.eMd && com.baidu.tieba.face.a.HD(obj) >= 10 && getContext() != null) {
                e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), tVar, this.eMG);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaz;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.eMG != null) {
            this.eMG.setFocusable(true);
            this.eMG.setFocusableInTouchMode(true);
            this.eMG.requestFocus();
            l.showSoftKeyPad(getContext(), this.eMG);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.aiB = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.eMG, R.color.cp_cont_f, 2, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.eMG, R.drawable.edittext_cursor);
            this.eMG.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.eMG, R.drawable.edittext_cursor_1);
            this.eMG.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        dEQ();
        ap.setImageResource(this.hWp, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEQ() {
        if (this.buB.isEnabled()) {
            ap.setViewTextColor(this.buB, R.color.cp_link_tip_a, 1, this.aiB);
        } else {
            ap.setViewTextColor(this.buB, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.eMG;
    }
}
