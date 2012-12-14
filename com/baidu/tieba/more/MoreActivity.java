package com.baidu.tieba.more;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.BaiduAccountProxy;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.PvThread;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import java.io.File;
/* loaded from: classes.dex */
public class MoreActivity extends BaseActivity {
    private AlertDialog mAbstractDialog;
    private Dialog mDialogEyeShieldTip;
    private AlertDialog mEyeShieldModeDialog;
    private AlertDialog mFontSizeDialog;
    private AlertDialog mFrequencyDialog;
    private AlertDialog mImageQualityDialog;
    private AlertDialog mPhotoSwitchDialog;
    private AlertDialog mPromotedDialog;
    private AlertDialog mRemindInfoDialog;
    private AlertDialog mRemindToneDialog;
    private AlertDialog mViewImageQualityDialog;
    private AlertDialog mViewImagesDialog;
    private LinearLayout mAccountManager = null;
    private LinearLayout mFrequency = null;
    private LinearLayout mRemindInfo = null;
    private LinearLayout mClearCash = null;
    private LinearLayout mImageQuality = null;
    private LinearLayout mViewImageQuality = null;
    private LinearLayout mViewImages = null;
    private LinearLayout mFontSize = null;
    private LinearLayout mAbout = null;
    private LinearLayout mPositionPaper = null;
    private LinearLayout mRemindTone = null;
    private LinearLayout mEyeShieldMode = null;
    private LinearLayout mAbstractState = null;
    private LinearLayout mPromotedMessage = null;
    private LinearLayout mShowPhoto = null;
    private TextView mFrequencyTime = null;
    private TextView mRemindToneInfo = null;
    private TextView mImageQualityInfo = null;
    private TextView mViewImageQualityInfo = null;
    private TextView mFontSizeInfo = null;
    private TextView mViewImagesInfo = null;
    private TextView mPromotedMessageInfo = null;
    private TextView mPhotoSwitch = null;
    private TextView mAbstractOn = null;
    private TextView mEyeShieldModeOn = null;
    private TextView mEyeShieldModeText = null;
    TextView accountText = null;
    private View.OnClickListener mClickListener = null;
    private String[] mFrequencyMenu = null;
    private ClearAsyncTask mClearTaks = null;
    private String[] mMsgInfoMenu = null;
    private String mUid = null;
    private boolean[] mMsgInfoMenuState = {TiebaApplication.app.isMsgReplymeOn(), TiebaApplication.app.isMsgAtmeOn(), TiebaApplication.app.isMsgFansOn()};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_activity);
        InitData();
        InitUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String id = TiebaApplication.getCurrentAccount();
        TiebaLog.i(getClass().getName(), "onResume", "id=" + id);
        if (id != null && !id.equals(this.mUid)) {
            updateFrequencyTime();
            this.mUid = id;
        } else if (id == null) {
            updateFrequencyTime();
            this.mUid = id;
        }
        if (TiebaApplication.isBaiduAccountManager()) {
            if (id == null || TiebaApplication.getCurrentAccountName() == null || TiebaApplication.getCurrentAccountName().equals("BaiduUser")) {
                this.accountText.setText(R.string.putin_account);
                this.mAccountManager.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View arg0) {
                        BaiduAccountProxy.getAccountData(MoreActivity.this, 0, MainTabActivity.GOTO_MORE, false);
                    }
                });
            } else {
                this.mAccountManager.setFocusable(false);
                this.mAccountManager.setClickable(false);
                this.accountText.setText(TiebaApplication.getCurrentAccountName());
            }
            ImageView image = (ImageView) findViewById(R.id.arrow);
            image.setVisibility(8);
        }
    }

    private void InitData() {
        this.mUid = TiebaApplication.getCurrentAccount();
        this.mFrequencyMenu = new String[4];
        this.mFrequencyMenu[0] = getString(R.string.half_minute);
        this.mFrequencyMenu[1] = getString(R.string.tow_minute);
        this.mFrequencyMenu[2] = getString(R.string.five_minute);
        this.mFrequencyMenu[3] = getString(R.string.close_remind);
        this.mMsgInfoMenu = new String[3];
        this.mMsgInfoMenu[0] = getString(R.string.mention_replyme);
        this.mMsgInfoMenu[1] = getString(R.string.mention_atme);
        this.mMsgInfoMenu[2] = getString(R.string.new_fans);
    }

    private void InitUI() {
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.account_manager /* 2131231043 */:
                        String id = TiebaApplication.getCurrentAccount();
                        if ((id == null || id.length() <= 0) && DatabaseService.getAccountNum() <= 0) {
                            LoginActivity.startActivity(MoreActivity.this, MainTabActivity.GOTO_MORE, MoreActivity.this.getString(R.string.login_manage_account), (int) RequestResponseCode.REQUEST_LOGIN_USE);
                            return;
                        } else {
                            AccountActivity.startActivity(MoreActivity.this);
                            return;
                        }
                    case R.id.account_name /* 2131231044 */:
                    case R.id.arrow /* 2131231045 */:
                    case R.id.frequency_time /* 2131231047 */:
                    case R.id.text_remind_tone /* 2131231050 */:
                    case R.id.eyeshield_mode_text /* 2131231052 */:
                    case R.id.eyeshield_mode_on /* 2131231053 */:
                    case R.id.abstract_state_on /* 2131231055 */:
                    case R.id.text_font_size /* 2131231057 */:
                    case R.id.show_photo_text /* 2131231059 */:
                    case R.id.photo_switch /* 2131231060 */:
                    case R.id.text_view_images /* 2131231062 */:
                    case R.id.text_view_images_switch /* 2131231064 */:
                    case R.id.text_upload_image_quality /* 2131231066 */:
                    case R.id.promoted_message_textview /* 2131231068 */:
                    default:
                        return;
                    case R.id.frequency /* 2131231046 */:
                        String id2 = TiebaApplication.getCurrentAccount();
                        if (id2 == null || id2.length() <= 0) {
                            LoginActivity.startActivity(MoreActivity.this, MainTabActivity.GOTO_MORE, MoreActivity.this.getString(R.string.login_get_msg), (int) RequestResponseCode.REQUEST_LOGIN_USE);
                            return;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(MoreActivity.this);
                        builder.setTitle(R.string.remind_frequency);
                        builder.setItems(MoreActivity.this.mFrequencyMenu, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setMsgFrequency(30);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setMsgFrequency(120);
                                        break;
                                    case 2:
                                        TiebaApplication.app.setMsgFrequency(300);
                                        break;
                                    case 3:
                                        TiebaApplication.app.setMsgFrequency(0);
                                        break;
                                }
                                DatabaseService.saveSettingData();
                                MoreActivity.this.updateFrequencyTime();
                            }
                        });
                        MoreActivity.this.mFrequencyDialog = builder.create();
                        MoreActivity.this.mFrequencyDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mFrequencyDialog.show();
                        return;
                    case R.id.remind_info /* 2131231048 */:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MoreActivity.this);
                        builder2.setTitle(R.string.remind_info);
                        builder2.setMultiChoiceItems(MoreActivity.this.mMsgInfoMenu, MoreActivity.this.mMsgInfoMenuState, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.2
                            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                switch (which) {
                                    case 0:
                                        if (isChecked) {
                                            TiebaApplication.app.setMsgReplymeOn(true);
                                            return;
                                        } else {
                                            TiebaApplication.app.setMsgReplymeOn(false);
                                            return;
                                        }
                                    case 1:
                                        if (isChecked) {
                                            TiebaApplication.app.setMsgAtmeOn(true);
                                            return;
                                        } else {
                                            TiebaApplication.app.setMsgAtmeOn(false);
                                            return;
                                        }
                                    case 2:
                                        if (isChecked) {
                                            TiebaApplication.app.setMsgFansOn(true);
                                            return;
                                        } else {
                                            TiebaApplication.app.setMsgFansOn(false);
                                            return;
                                        }
                                    default:
                                        return;
                                }
                            }
                        });
                        builder2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.more.MoreActivity.2.3
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialog) {
                                DatabaseService.saveSettingData();
                            }
                        });
                        MoreActivity.this.mRemindInfoDialog = builder2.create();
                        MoreActivity.this.mRemindInfoDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mRemindInfoDialog.show();
                        return;
                    case R.id.remind_tone /* 2131231049 */:
                        MoreActivity.this.mRemindToneDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.remind_tone).setItems(R.array.menu_remind_tone, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.7
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setMsgTone(true);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setMsgTone(false);
                                        break;
                                }
                                DatabaseService.saveSettingData();
                                MoreActivity.this.updateRemindTone();
                            }
                        }).create();
                        MoreActivity.this.mRemindToneDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.more.MoreActivity.2.8
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialog) {
                                DatabaseService.saveSettingData();
                            }
                        });
                        MoreActivity.this.mRemindToneDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mRemindToneDialog.show();
                        return;
                    case R.id.eyeshield_mode /* 2131231051 */:
                        MoreActivity.this.openEyeShieldSettingDialog();
                        PvThread pv = new PvThread(Config.ST_TYPE_EYESHIELD_MODE);
                        pv.start();
                        return;
                    case R.id.abstract_selection /* 2131231054 */:
                        if (MoreActivity.this.mAbstractDialog == null) {
                            MoreActivity.this.mAbstractDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.abstract_state).setItems(R.array.menu_view_images, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.12
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case 0:
                                            TiebaApplication.app.setIsAbstractOn(true);
                                            break;
                                        case 1:
                                            TiebaApplication.app.setIsAbstractOn(false);
                                            break;
                                    }
                                    MoreActivity.this.updateAbstracSwitch();
                                }
                            }).create();
                        }
                        MoreActivity.this.mAbstractDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mAbstractDialog.show();
                        return;
                    case R.id.font_size /* 2131231056 */:
                        SpannableString fontBig = new SpannableString(MoreActivity.this.getString(R.string.font_size_big));
                        fontBig.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 18.0f)), 0, fontBig.length(), 18);
                        SpannableString fontMid = new SpannableString(MoreActivity.this.getString(R.string.font_size_mid));
                        fontMid.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 17.0f)), 0, fontMid.length(), 18);
                        SpannableString fontSmall = new SpannableString(MoreActivity.this.getString(R.string.font_size_small));
                        fontSmall.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 0, fontSmall.length(), 18);
                        CharSequence[] menuFontSize = {fontBig, fontMid, fontSmall};
                        MoreActivity.this.mFontSizeDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.font_size).setItems(menuFontSize, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setFontSize(1);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setFontSize(2);
                                        break;
                                    case 2:
                                        TiebaApplication.app.setFontSize(3);
                                        break;
                                }
                                MoreActivity.this.updateFontSize();
                            }
                        }).create();
                        MoreActivity.this.mFontSizeDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mFontSizeDialog.show();
                        return;
                    case R.id.show_photo /* 2131231058 */:
                        if (MoreActivity.this.mPhotoSwitchDialog == null) {
                            MoreActivity.this.mPhotoSwitchDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.show_photo).setItems(R.array.menu_view_images, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.11
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case 0:
                                            TiebaApplication.app.setDisplayPhoto(true);
                                            break;
                                        case 1:
                                            TiebaApplication.app.setDisplayPhoto(false);
                                            break;
                                    }
                                    MoreActivity.this.updatePhotoSwitch();
                                }
                            }).create();
                        }
                        MoreActivity.this.mPhotoSwitchDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mPhotoSwitchDialog.show();
                        return;
                    case R.id.view_images /* 2131231061 */:
                        MoreActivity.this.mViewImagesDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.view_images).setItems(R.array.menu_view_images, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.9
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setShowImages(true);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setShowImages(false);
                                        break;
                                }
                                MoreActivity.this.updateIsShowImages();
                            }
                        }).create();
                        MoreActivity.this.mViewImagesDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mViewImagesDialog.show();
                        return;
                    case R.id.view_images_quality /* 2131231063 */:
                        SpannableString viewQualityHigh = new SpannableString(MoreActivity.this.getString(R.string.view_image_quality_high_menu));
                        viewQualityHigh.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, viewQualityHigh.length(), 18);
                        SpannableString viewQualityLow = new SpannableString(MoreActivity.this.getString(R.string.view_image_quality_low_menu));
                        viewQualityLow.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, viewQualityLow.length(), 18);
                        CharSequence[] menuImageQuality = {viewQualityHigh, viewQualityLow};
                        MoreActivity.this.mViewImageQualityDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.view_images_quality).setItems(menuImageQuality, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setViewImageQuality(1);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setViewImageQuality(2);
                                        break;
                                }
                                MoreActivity.this.updateViewImageQuality();
                            }
                        }).create();
                        MoreActivity.this.mViewImageQualityDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mViewImageQualityDialog.show();
                        return;
                    case R.id.upload_image_quality /* 2131231065 */:
                        SpannableString qualityHigh = new SpannableString(MoreActivity.this.getString(R.string.image_quality_high_menu));
                        qualityHigh.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, qualityHigh.length(), 18);
                        SpannableString qualityLow = new SpannableString(MoreActivity.this.getString(R.string.image_quality_low_menu));
                        qualityLow.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, qualityLow.length(), 18);
                        CharSequence[] menuViewImageQuality = {qualityHigh, MoreActivity.this.getString(R.string.image_quality_mid_menu), qualityLow};
                        MoreActivity.this.mImageQualityDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.upload_image_quality).setItems(menuViewImageQuality, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setUploadImageQuality(1);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setUploadImageQuality(2);
                                        break;
                                    case 2:
                                        TiebaApplication.app.setUploadImageQuality(3);
                                        break;
                                }
                                MoreActivity.this.updateImageQuality();
                            }
                        }).create();
                        MoreActivity.this.mImageQualityDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mImageQualityDialog.show();
                        return;
                    case R.id.promoted_message /* 2131231067 */:
                        MoreActivity.this.mPromotedDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.promoted_message_text).setItems(R.array.menu_remind_tone, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.2.10
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setPromotedMessage(true);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setPromotedMessage(false);
                                        break;
                                }
                                MoreActivity.this.updatePromotedTone();
                            }
                        }).create();
                        MoreActivity.this.mPromotedDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mPromotedDialog.show();
                        return;
                    case R.id.clear_cash /* 2131231069 */:
                        if (MoreActivity.this.mClearTaks == null) {
                            MoreActivity.this.mClearTaks = new ClearAsyncTask(MoreActivity.this, null);
                            MoreActivity.this.mClearTaks.execute(new String[0]);
                            return;
                        }
                        return;
                    case R.id.about_bieta /* 2131231070 */:
                        AboutActivity.startActivity(MoreActivity.this);
                        return;
                    case R.id.position_paper /* 2131231071 */:
                        MoreActivity.this.writeFeedback();
                        return;
                }
            }
        };
        this.mAccountManager = (LinearLayout) findViewById(R.id.account_manager);
        this.accountText = (TextView) findViewById(R.id.account_name);
        this.mAccountManager.setOnClickListener(this.mClickListener);
        this.mFrequency = (LinearLayout) findViewById(R.id.frequency);
        this.mFrequency.setOnClickListener(this.mClickListener);
        this.mRemindInfo = (LinearLayout) findViewById(R.id.remind_info);
        this.mRemindInfo.setOnClickListener(this.mClickListener);
        this.mRemindTone = (LinearLayout) findViewById(R.id.remind_tone);
        this.mRemindTone.setOnClickListener(this.mClickListener);
        this.mClearCash = (LinearLayout) findViewById(R.id.clear_cash);
        this.mClearCash.setOnClickListener(this.mClickListener);
        this.mAbout = (LinearLayout) findViewById(R.id.about_bieta);
        this.mAbout.setOnClickListener(this.mClickListener);
        this.mPositionPaper = (LinearLayout) findViewById(R.id.position_paper);
        this.mPositionPaper.setOnClickListener(this.mClickListener);
        this.mPromotedMessage = (LinearLayout) findViewById(R.id.promoted_message);
        this.mPromotedMessage.setOnClickListener(this.mClickListener);
        this.mFrequencyTime = (TextView) findViewById(R.id.frequency_time);
        this.mRemindToneInfo = (TextView) findViewById(R.id.text_remind_tone);
        this.mPromotedMessageInfo = (TextView) findViewById(R.id.promoted_message_textview);
        this.mViewImageQuality = (LinearLayout) findViewById(R.id.view_images_quality);
        this.mViewImageQuality.setOnClickListener(this.mClickListener);
        this.mImageQuality = (LinearLayout) findViewById(R.id.upload_image_quality);
        this.mImageQuality.setOnClickListener(this.mClickListener);
        this.mViewImages = (LinearLayout) findViewById(R.id.view_images);
        this.mViewImages.setOnClickListener(this.mClickListener);
        this.mFontSize = (LinearLayout) findViewById(R.id.font_size);
        this.mFontSize.setOnClickListener(this.mClickListener);
        this.mImageQualityInfo = (TextView) findViewById(R.id.text_upload_image_quality);
        this.mViewImageQualityInfo = (TextView) findViewById(R.id.text_view_images_switch);
        this.mViewImagesInfo = (TextView) findViewById(R.id.text_view_images);
        this.mFontSizeInfo = (TextView) findViewById(R.id.text_font_size);
        this.mShowPhoto = (LinearLayout) findViewById(R.id.show_photo);
        this.mShowPhoto.setOnClickListener(this.mClickListener);
        this.mPhotoSwitch = (TextView) findViewById(R.id.photo_switch);
        this.mEyeShieldModeText = (TextView) findViewById(R.id.eyeshield_mode_text);
        this.mEyeShieldMode = (LinearLayout) findViewById(R.id.eyeshield_mode);
        this.mEyeShieldModeOn = (TextView) findViewById(R.id.eyeshield_mode_on);
        this.mEyeShieldMode.setOnClickListener(this.mClickListener);
        this.mAbstractState = (LinearLayout) findViewById(R.id.abstract_selection);
        this.mAbstractOn = (TextView) findViewById(R.id.abstract_state_on);
        this.mAbstractState.setOnClickListener(this.mClickListener);
        if (TiebaApplication.app.getDisplayEyeShieldModeNew() == null) {
            String str = getString(R.string.eyeshield_mode);
            int start = str.length();
            SpannableString info = new SpannableString(String.valueOf(str) + " NEW");
            info.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), start, " NEW".length() + start, 33);
            info.setSpan(new RelativeSizeSpan(0.8f), start, " NEW".length() + start, 33);
            this.mEyeShieldModeText.setText(info);
        }
        updateFrequencyTime();
        updateImageQuality();
        updateIsShowImages();
        updateFontSize();
        updateRemindTone();
        updateViewImageQuality();
        updatePromotedTone();
        updatePhotoSwitch();
        updateAbstracSwitch();
        updateEyeShieldModeSwitch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEyeShieldSettingDialog() {
        if (this.mEyeShieldModeDialog == null) {
            this.mEyeShieldModeDialog = new AlertDialog.Builder(this).setTitle(R.string.eyeshield_mode).setItems(R.array.menu_view_images, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            TiebaApplication.app.setIsEyeShieldModeOn(true);
                            if (CompatibleUtile.getInstance().isAutoBrightness(MoreActivity.this)) {
                                MoreActivity.this.openEyeShieldTipDialog();
                                break;
                            }
                            break;
                        case 1:
                            TiebaApplication.app.setIsEyeShieldModeOn(false);
                            break;
                    }
                    MoreActivity.this.updateEyeShieldModeSwitch();
                    UtilHelper.setEyeShieldMode(MoreActivity.this);
                }
            }).create();
        }
        this.mEyeShieldModeDialog.setCanceledOnTouchOutside(true);
        this.mEyeShieldModeDialog.show();
        if (TiebaApplication.app.getDisplayEyeShieldModeNew() == null) {
            TiebaApplication.app.setDisplayEyeShieldModeNew();
            this.mEyeShieldModeText.setText(getString(R.string.eyeshield_mode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEyeShieldTipDialog() {
        if (this.mDialogEyeShieldTip == null) {
            this.mDialogEyeShieldTip = new Dialog(this, R.style.common_alert_dialog);
            this.mDialogEyeShieldTip.setCanceledOnTouchOutside(true);
            this.mDialogEyeShieldTip.setCancelable(true);
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog_tip_bright_setting, (ViewGroup) null);
            this.mDialogEyeShieldTip.setContentView(view);
            WindowManager.LayoutParams wmParams = this.mDialogEyeShieldTip.getWindow().getAttributes();
            wmParams.width = (int) (UtilHelper.getEquipmentWidth(this) * 0.9d);
            this.mDialogEyeShieldTip.getWindow().setAttributes(wmParams);
            Button mBtnOk = (Button) view.findViewById(R.id.dialog_button_ok);
            Button mBtnCancel = (Button) view.findViewById(R.id.dialog_button_cancel);
            mBtnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    MoreActivity.this.mDialogEyeShieldTip.dismiss();
                }
            });
            mBtnOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        try {
                            Intent intent = new Intent("/");
                            ComponentName cm = new ComponentName("com.android.settings", "com.android.settings.DisplaySettings");
                            intent.setComponent(cm);
                            intent.setAction("android.intent.action.VIEW");
                            MoreActivity.this.startActivityForResult(intent, 0);
                            MoreActivity.this.mDialogEyeShieldTip.dismiss();
                        } catch (Exception e) {
                            MoreActivity.this.showToast(MoreActivity.this.getString(R.string.goto_setting_tip));
                            MoreActivity.this.mDialogEyeShieldTip.dismiss();
                        }
                    } catch (Throwable th) {
                        MoreActivity.this.mDialogEyeShieldTip.dismiss();
                        throw th;
                    }
                }
            });
        }
        this.mDialogEyeShieldTip.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePhotoSwitch() {
        if (TiebaApplication.app.getDisplayPhoto()) {
            this.mPhotoSwitch.setText(getString(R.string.view_images_open));
        } else {
            this.mPhotoSwitch.setText(getString(R.string.view_images_close));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeFeedback() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_feedback), true, (int) RequestResponseCode.REQUEST_FEEDBACK);
            return;
        }
        AntiData anti = new AntiData();
        anti.setIfpost(1);
        WriteActivity.startActivityFeedBack(this, Config.POSITION_PAGER_ID, Config.POSITION_PAGER_NAME, anti);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_FEEDBACK /* 1200007 */:
                    writeFeedback();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrequencyTime() {
        if (TiebaApplication.app.getMsgFrequency() <= 0) {
            this.mFrequencyTime.setText(R.string.close);
            this.mRemindInfo.setVisibility(8);
            this.mRemindTone.setVisibility(8);
            this.mFrequency.setBackgroundResource(R.drawable.more_all);
            return;
        }
        if (TiebaApplication.app.getMsgFrequency() == 30) {
            this.mFrequencyTime.setText(R.string.half_minute);
        } else if (TiebaApplication.app.getMsgFrequency() == 120) {
            this.mFrequencyTime.setText(R.string.tow_minute);
        } else {
            this.mFrequencyTime.setText(R.string.five_minute);
        }
        this.mRemindInfo.setVisibility(0);
        this.mRemindTone.setVisibility(0);
        this.mFrequency.setBackgroundResource(R.drawable.more_up);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePromotedTone() {
        if (TiebaApplication.app.isPromotedMessageOn()) {
            this.mPromotedMessageInfo.setText(R.string.promote_message_on);
        } else {
            this.mPromotedMessageInfo.setText(R.string.promote_message_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemindTone() {
        if (TiebaApplication.app.isMsgToneOn()) {
            this.mRemindToneInfo.setText(getString(R.string.remind_tone_open));
        } else {
            this.mRemindToneInfo.setText(getString(R.string.remind_tone_close));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageQuality() {
        switch (TiebaApplication.app.getUploadImageQuality()) {
            case 1:
                this.mImageQualityInfo.setText(getString(R.string.image_quality_high));
                return;
            case 2:
                this.mImageQualityInfo.setText(getString(R.string.image_quality_mid));
                return;
            case 3:
                this.mImageQualityInfo.setText(getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewImageQuality() {
        switch (TiebaApplication.app.getViewImageQuality()) {
            case 1:
                this.mViewImageQualityInfo.setText(getString(R.string.image_quality_high));
                return;
            case 2:
                this.mViewImageQualityInfo.setText(getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIsShowImages() {
        if (TiebaApplication.app.isShowImages()) {
            this.mViewImagesInfo.setText(getString(R.string.view_images_open));
            this.mViewImageQuality.setVisibility(0);
            return;
        }
        this.mViewImagesInfo.setText(getString(R.string.view_images_close));
        this.mViewImageQuality.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFontSize() {
        switch (TiebaApplication.app.getFontSize()) {
            case 1:
                this.mFontSizeInfo.setText(getString(R.string.font_size_big));
                return;
            case 2:
                this.mFontSizeInfo.setText(getString(R.string.font_size_mid));
                return;
            case 3:
                this.mFontSizeInfo.setText(getString(R.string.font_size_small));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAbstracSwitch() {
        if (TiebaApplication.app.getIsAbstractState()) {
            this.mAbstractOn.setText(R.string.abstract_on);
        } else {
            this.mAbstractOn.setText(R.string.abstract_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEyeShieldModeSwitch() {
        if (TiebaApplication.app.getIsEyeShieldMode()) {
            this.mEyeShieldModeOn.setText(R.string.eyeshield_mode_open);
        } else {
            this.mEyeShieldModeOn.setText(R.string.eyeshield_mode_close);
        }
    }

    /* loaded from: classes.dex */
    private class ClearAsyncTask extends AsyncTask<String, Integer, String> {
        private ClearAsyncTask() {
        }

        /* synthetic */ ClearAsyncTask(MoreActivity moreActivity, ClearAsyncTask clearAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ClearAsyncTask) result);
            MoreActivity.this.mClearTaks = null;
            MoreActivity.this.closeLoadingDialog();
            MoreActivity.this.showToast(MoreActivity.this.getString(R.string.image_cash_del_suc));
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            MoreActivity.this.showLoadingDialog(MoreActivity.this.getString(R.string.deleting));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... arg0) {
            DatabaseService.deletSdDatebase();
            try {
                File file = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + Config.TMP_PIC_DIR_NAME + "/");
                File[] list = file.listFiles();
                if (list != null) {
                    for (File file2 : list) {
                        file2.delete();
                    }
                }
                File file3 = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + Config.TMP_HOTSPOT_DIR_NAME + "/");
                File[] list2 = file3.listFiles();
                if (list2 != null) {
                    for (File file4 : list2) {
                        file4.delete();
                    }
                }
                File[] fileArr = null;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
            }
            return null;
        }
    }

    public void closeMenuDialog() {
        if (this.mFrequencyDialog != null) {
            this.mFrequencyDialog.dismiss();
        }
        if (this.mRemindInfoDialog != null) {
            this.mRemindInfoDialog.dismiss();
        }
        if (this.mImageQualityDialog != null) {
            this.mImageQualityDialog.dismiss();
        }
        if (this.mViewImagesDialog != null) {
            this.mViewImagesDialog.dismiss();
        }
        if (this.mFontSizeDialog != null) {
            this.mFontSizeDialog.dismiss();
        }
        if (this.mRemindInfoDialog != null) {
            this.mRemindInfoDialog.dismiss();
        }
        if (this.mAbstractDialog != null) {
            this.mAbstractDialog.dismiss();
        }
        if (this.mEyeShieldModeDialog != null) {
            this.mEyeShieldModeDialog.dismiss();
        }
        if (this.mPromotedDialog != null) {
            this.mPromotedDialog.dismiss();
        }
    }
}
