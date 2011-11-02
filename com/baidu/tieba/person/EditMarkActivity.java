package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity {
    private MarkAdapter mAdapter = null;
    private MarklistModel mModel = null;
    private int mClickItem = -1;
    private ListView mList = null;
    private AlertDialog mDialog = null;
    private Button mBack = null;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        String[] items = {getString(R.string.delete), getString(R.string.cancel)};
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.person.EditMarkActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    ArrayList<MarkData> datas = EditMarkActivity.this.mAdapter.getData();
                    if (datas != null && EditMarkActivity.this.mClickItem >= 0 && EditMarkActivity.this.mClickItem < datas.size()) {
                        boolean ret = DatabaseService.deleteMarkData(datas.get(EditMarkActivity.this.mClickItem).getId());
                        if (ret) {
                            datas.remove(EditMarkActivity.this.mClickItem);
                            EditMarkActivity.this.mAdapter.checkNodata();
                            EditMarkActivity.this.mAdapter.notifyDataSetChanged();
                            EditMarkActivity.this.showToast(EditMarkActivity.this.getString(R.string.success));
                            return;
                        }
                        EditMarkActivity.this.showToast(EditMarkActivity.this.getString(R.string.fail));
                        return;
                    }
                    return;
                }
                dialog.dismiss();
            }
        });
        this.mDialog = builder.create();
        this.mAdapter = new MarkAdapter(this, this.mModel.getMark_list());
        this.mAdapter.setDisplayNull(false);
        this.mAdapter.checkNodata();
        this.mList = (ListView) findViewById(R.id.list);
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.person.EditMarkActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                MarkData data = (MarkData) EditMarkActivity.this.mAdapter.getItem(arg2);
                EditMarkActivity.this.mClickItem = arg2;
                if (data != null) {
                    EditMarkActivity.this.mDialog.show();
                }
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.EditMarkActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditMarkActivity.this.finish();
            }
        });
    }
}
