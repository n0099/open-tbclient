package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class FrsImageThread extends Thread {
    public static int TYPE_ADD = 1;
    public static int TYPE_DEL = 2;
    public static int TYPE_INIT = 3;
    private Hashtable<String, Integer> mFrsImageForums;
    private String mName;
    private int mType;

    public FrsImageThread(Hashtable<String, Integer> forums) {
        this.mType = TYPE_INIT;
        this.mName = null;
        this.mFrsImageForums = null;
        this.mType = TYPE_INIT;
        this.mFrsImageForums = forums;
    }

    public FrsImageThread(int type, String name) {
        this.mType = TYPE_INIT;
        this.mName = null;
        this.mFrsImageForums = null;
        this.mType = type;
        this.mName = name;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<String> data;
        super.run();
        try {
            if (this.mType == TYPE_INIT) {
                if (this.mFrsImageForums != null && (data = DatabaseService.getAllFrsImageForums()) != null) {
                    int num = data.size();
                    for (int i = 0; i < num; i++) {
                        this.mFrsImageForums.put(data.get(i), 1);
                    }
                }
            } else if (this.mType == TYPE_DEL) {
                DatabaseService.delFrsImageForum(this.mName);
            } else if (this.mType == TYPE_ADD) {
                DatabaseService.insertFrsImageForum(this.mName);
            }
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "run", e.getMessage());
        }
    }
}
