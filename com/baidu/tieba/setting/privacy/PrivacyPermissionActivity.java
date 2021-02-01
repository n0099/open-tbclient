package com.baidu.tieba.setting.privacy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PrivacyPermissionActivity extends BaseActivity<PrivacyPermissionActivity> {
    private View mBack;
    private NavigationBar mNavigationBar;
    private RecyclerView mRecyclerView;
    private View mRootView;
    private List<a> mDataList = new ArrayList();
    private String[] njp = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE", PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_FINE_LOCATION"};
    private String[] njq = {getString(R.string.allow_to_use_camera), getString(R.string.allow_to_use_sdcard), getString(R.string.allow_to_use_record), getString(R.string.allow_to_use_location)};
    private String[] njr = {getString(R.string.privacy_camera_info), getString(R.string.privacy_sdcard_info), getString(R.string.privacy_record_info), getString(R.string.privacy_location_info)};
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.1
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new PermissionViewHolder(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(R.layout.layout_privacy_permisson_item, viewGroup, false));
            }
            if (i != 1) {
                return null;
            }
            return new PermissionDetailHolder(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(R.layout.textview_permission_detail, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                ((PermissionViewHolder) viewHolder).a((a) PrivacyPermissionActivity.this.mDataList.get(i));
                ((PermissionViewHolder) viewHolder).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else if (itemViewType == 1) {
                ((PermissionDetailHolder) viewHolder).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            a aVar = (a) PrivacyPermissionActivity.this.mDataList.get(i);
            if (aVar == null) {
                return 0;
            }
            return aVar.bHt;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PrivacyPermissionActivity.this.mDataList.size();
        }
    };

    /* loaded from: classes8.dex */
    public static class a {
        public int bHt = 0;
        public String info;
        public boolean isOpen;
        public String name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.privacy_permission_activity);
        this.mRootView = findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.privacy_permission));
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
        for (int i = 0; i < this.njp.length; i++) {
            a aVar = new a();
            aVar.bHt = 0;
            aVar.name = this.njq[i];
            aVar.info = this.njr[i];
            this.mDataList.add(aVar);
        }
        a aVar2 = new a();
        aVar2.bHt = 1;
        this.mDataList.add(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mDataList.size() >= this.njp.length) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.njp.length) {
                    this.mDataList.get(i2).isOpen = ae.aA(getActivity(), this.njp[i2]);
                    i = i2 + 1;
                } else {
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
        this.mAdapter.notifyDataSetChanged();
    }

    /* loaded from: classes8.dex */
    public static class PermissionViewHolder extends RecyclerView.ViewHolder {
        private View.OnClickListener mOnClickListener;
        private int mSkinType;
        private TbSettingTextTipView njv;
        private TextView njw;

        public PermissionViewHolder(View view) {
            super(view);
            this.mSkinType = 3;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.PermissionViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PermissionViewHolder.this.itemView != null) {
                        Intent intent = new Intent();
                        intent.addFlags(268435456);
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", PermissionViewHolder.this.itemView.getContext().getPackageName(), null));
                        PermissionViewHolder.this.itemView.getContext().startActivity(intent);
                    }
                }
            };
            this.njv = (TbSettingTextTipView) view.findViewById(R.id.privacy_name);
            this.njv.setOnClickListener(this.mOnClickListener);
            this.njw = (TextView) view.findViewById(R.id.privacy_info);
        }

        public void a(a aVar) {
            String string;
            if (aVar != null && this.itemView != null) {
                this.njv.setText(aVar.name);
                TbSettingTextTipView tbSettingTextTipView = this.njv;
                if (aVar.isOpen) {
                    string = this.itemView.getContext().getString(R.string.privacy_permisson_open);
                } else {
                    string = this.itemView.getContext().getString(R.string.privacy_permisson_closed);
                }
                tbSettingTextTipView.setTip(string);
                this.njw.setText(aVar.info);
            }
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.njv.onChangeSkinType(i);
                ap.setBackgroundResource(this.njv, R.drawable.more_all);
                ap.setBackgroundColor(this.njw, R.color.CAM_X0204);
                ap.setViewTextColor(this.njw, R.color.CAM_X0108);
                this.mSkinType = i;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class PermissionDetailHolder extends RecyclerView.ViewHolder {
        private View.OnClickListener mOnClickListener;
        private int mSkinType;
        private TextView njt;

        public PermissionDetailHolder(View view) {
            super(view);
            this.mSkinType = 3;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.PermissionDetailHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.startWebActivity(PermissionDetailHolder.this.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
                }
            };
            this.njt = (TextView) view;
            this.njt.setOnClickListener(this.mOnClickListener);
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setViewTextColor(this.njt, R.color.CAM_X0302);
                ap.setBackgroundResource(this.itemView, R.drawable.more_all);
                this.mSkinType = i;
            }
        }
    }
}
