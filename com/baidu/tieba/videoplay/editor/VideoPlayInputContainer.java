package com.baidu.tieba.videoplay.editor;

import android.content.Context;
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
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import com.baidu.tieba.write.j;
import java.util.regex.Matcher;
/* loaded from: classes8.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools acR;
    private int acS;
    private int ajU;
    private TextView bUX;
    private boolean fCU;
    private boolean fCV;
    private boolean fCW;
    private int fCX;
    private EditText fDZ;
    private LinearLayout fEd;
    private ImageView jjJ;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCU = false;
        this.fCV = true;
        this.fCW = true;
        this.fCX = -1;
        this.ajU = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fEd = new LinearLayout(getContext());
        this.fEd.setOrientation(0);
        this.fEd.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fEd, new LinearLayout.LayoutParams(-1, -2));
        hc(context);
        fn(context);
        fm(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void hc(Context context) {
        this.jjJ = new ImageView(context);
        this.jjJ.setEnabled(true);
        this.jjJ.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.jjJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fEd.addView(this.jjJ, layoutParams);
    }

    private void fn(Context context) {
        this.fDZ = new EditText(context);
        this.fDZ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fDZ.setMaxLines(4);
        this.fDZ.setGravity(16);
        this.fDZ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fDZ.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fDZ, R.drawable.edittext_cursor);
        this.fDZ.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fDZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fDZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.fCW) {
                    VideoPlayInputContainer.this.fCW = true;
                    if (VideoPlayInputContainer.this.fCX != -1) {
                        VideoPlayInputContainer.this.fDZ.setSelection(VideoPlayInputContainer.this.fCX);
                        VideoPlayInputContainer.this.fCX = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fDZ.getText().toString()));
                }
                VideoPlayInputContainer.this.bUX.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dVH();
            }
        });
        this.fDZ.setHint(context.getString(R.string.reply_something));
        this.fDZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fDZ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fEd.addView(this.fDZ, layoutParams);
    }

    private void fm(Context context) {
        this.bUX = new TextView(context);
        this.bUX.setGravity(17);
        this.bUX.setIncludeFontPadding(false);
        this.bUX.setEnabled(false);
        this.bUX.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bUX.setText(R.string.send_replay);
        this.bUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fEd.addView(this.bUX, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fDZ.getSelectionStart() > 0) {
                        String substring = this.fDZ.getText().toString().substring(0, this.fDZ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iSk.matcher(substring);
                        if (matcher.find()) {
                            this.fDZ.getText().delete(this.fDZ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fDZ.getSelectionStart());
                            return;
                        }
                        this.fDZ.getText().delete(this.fDZ.getSelectionStart() - 1, this.fDZ.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fDZ.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fDZ.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fDZ.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fDZ.setSelection(VideoPlayInputContainer.this.fDZ.getText().length());
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
                        this.fDZ.setText((CharSequence) null);
                    }
                    this.bUX.setEnabled(false);
                    dVH();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bwv() == EmotionGroupType.NET_SUG) {
                            a(uVar);
                            return;
                        } else {
                            b(uVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fDZ.getText().toString();
            if (this.fCV && com.baidu.tieba.face.a.Js(obj) >= 10 && getContext() != null) {
                e.brY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fDZ);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fCU || uVar.bwv() == EmotionGroupType.LOCAL) {
            String obj = this.fDZ.getText().toString();
            if (this.fCV && com.baidu.tieba.face.a.Js(obj) >= 10 && getContext() != null) {
                e.brY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fDZ);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fDZ != null) {
            this.fDZ.setFocusable(true);
            this.fDZ.setFocusableInTouchMode(true);
            this.fDZ.requestFocus();
            l.showSoftKeyPad(getContext(), this.fDZ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ajU = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.fDZ, R.color.CAM_X0106, 2, i);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fDZ, R.drawable.edittext_cursor);
            this.fDZ.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            j.h(this.fDZ, R.drawable.edittext_cursor_1);
            this.fDZ.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        dVH();
        ap.setImageResource(this.jjJ, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVH() {
        if (this.bUX.isEnabled()) {
            ap.setViewTextColor(this.bUX, R.color.CAM_X0302, 1, this.ajU);
        } else {
            ap.setViewTextColor(this.bUX, R.color.CAM_X0107, 1);
        }
    }

    public EditText getInputView() {
        return this.fDZ;
    }
}
