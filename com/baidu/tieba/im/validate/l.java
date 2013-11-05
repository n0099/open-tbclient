package com.baidu.tieba.im.validate;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f1726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(List list) {
        this.f1726a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        int size = this.f1726a.size();
        int i = 0;
        while (true) {
            if (i < size) {
                ValidateItemData validateItemData = (ValidateItemData) this.f1726a.get(i);
                if (validateItemData == null) {
                    break;
                }
                if (!validateItemData.isShown()) {
                    validateItemData.setShown(true);
                    linkedList.add(new GroupNewsPojo(validateItemData));
                }
                i++;
            } else {
                com.baidu.tieba.im.db.g.a().a(linkedList);
                break;
            }
        }
        return null;
    }
}
