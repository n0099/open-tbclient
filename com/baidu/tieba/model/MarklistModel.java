package com.baidu.tieba.model;

import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MarklistModel {
    private ArrayList<MarkData> mark_list = new ArrayList<>();

    public ArrayList<MarkData> getMark_list() {
        return this.mark_list;
    }

    public void setMark_list(ArrayList<MarkData> mark_list) {
        this.mark_list = mark_list;
    }

    public void doDB() {
        ArrayList<MarkData> ret = DatabaseService.getAllMarkData();
        if (ret != null) {
            setMark_list(ret);
        }
    }
}
