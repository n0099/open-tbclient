package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.home.MarkAdapter;
import com.baidu.tieba.model.MarklistModel;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity {
    private MarkAdapter mAdapter = null;
    private MarklistModel mModel = null;
    private ListView mList = null;
    private Button mBack = null;
    private Button mEdit = null;

    public static void startActivityForResult(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, EditMarkActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_mark_activity);
        InitData();
        InitUI();
    }

    private void InitData() {
        this.mModel = new MarklistModel();
        this.mModel.setMark_list(DatabaseService.getAllMarkData());
    }

    private void InitUI() {
        this.mAdapter = new MarkAdapter(this, this.mModel.getMark_list());
        this.mAdapter.setDisplayNull(true);
        this.mAdapter.checkNodata();
        this.mList = (ListView) findViewById(R.id.list);
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.person.EditMarkActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                MarkData data = (MarkData) EditMarkActivity.this.mAdapter.getItem(arg2);
                if (data != null) {
                    PbActivity.startAcitivity(EditMarkActivity.this, data);
                }
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.EditMarkActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditMarkActivity.this.finish();
            }
        });
        this.mEdit = (Button) findViewById(R.id.edit);
        this.mEdit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.EditMarkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (!EditMarkActivity.this.mAdapter.getEditState()) {
                    EditMarkActivity.this.mAdapter.setEditState(true);
                    EditMarkActivity.this.mEdit.setText(R.string.done);
                    EditMarkActivity.this.mAdapter.notifyDataSetChanged();
                    return;
                }
                EditMarkActivity.this.mAdapter.setEditState(false);
                EditMarkActivity.this.mEdit.setText(R.string.edit);
                EditMarkActivity.this.mAdapter.notifyDataSetChanged();
            }
        });
        if (this.mModel.getMark_list().size() == 0) {
            this.mEdit.setVisibility(4);
        }
        this.mAdapter.setDelMarkListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.EditMarkActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int position = ((Integer) arg0.getTag()).intValue();
                if (EditMarkActivity.this.mAdapter.getData() != null) {
                    MarkData data = EditMarkActivity.this.mAdapter.getData().get(position);
                    boolean ret = DatabaseService.deleteMarkData(data.getId());
                    if (ret) {
                        ArrayList<MarkData> list = EditMarkActivity.this.mModel.getMark_list();
                        if (list != null) {
                            list.remove(position);
                            EditMarkActivity.this.mAdapter.setData(list);
                            EditMarkActivity.this.mAdapter.checkNodata();
                            if (list.size() == 0) {
                                EditMarkActivity.this.mEdit.setText(R.string.edit);
                                EditMarkActivity.this.mEdit.setVisibility(4);
                                EditMarkActivity.this.mAdapter.setEditState(false);
                            }
                            EditMarkActivity.this.mAdapter.notifyDataSetChanged();
                        }
                        EditMarkActivity.this.showToast(EditMarkActivity.this.getString(R.string.success));
                        return;
                    }
                    EditMarkActivity.this.showToast(EditMarkActivity.this.getString(R.string.fail));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (DatabaseService.getMarkState().booleanValue()) {
            this.mModel.setMark_list(DatabaseService.getAllMarkData());
            ArrayList<MarkData> list = this.mModel.getMark_list();
            if (list != null) {
                this.mAdapter.setData(list);
                this.mAdapter.checkNodata();
                this.mAdapter.notifyDataSetInvalidated();
                if (list.size() == 0) {
                    this.mEdit.setVisibility(4);
                } else {
                    this.mEdit.setVisibility(0);
                }
            }
        }
    }
}
